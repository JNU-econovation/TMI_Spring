package com.example.honeybe_spring.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class JwtAuthenticationProvider{

    private String secretKey = "thisissecretkeythisissecretkeythisissecretkey";
    private long tokenValidTime = 1000L * 60 * 60;

    private UserDetailsService userDetailsService;

    // 객체 초기화, secretKey를 Base64로 인코딩함
    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT 토큰 생성
    //public String createToken(String userPk, List<String> roles){
    public String createToken(String userPk){
        Claims claims = Jwts.claims().setSubject(userPk);
        // claims.put("roles", roles);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)  // 정보 저장
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+tokenValidTime))  // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();     // signature에 들어갈 secret값 세팅
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    // 토큰에서 회원 정보 추출
    public String getUserPk(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // Request의 Header에서 token 값을 가져온다. -> "X-AUTH-TOKEN": "TOKEN값"
    public String resolveToken(HttpServletRequest request){
        String token = null;
        Cookie cookie = WebUtils.getCookie(request, "X-AUTH-TOKEN");
        if (cookie != null) token = cookie.getValue();
        return token;
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken){
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claimsJws.getBody().getExpiration().before(new Date());
        }catch (Exception e){
            return false;
        }
    }
}
