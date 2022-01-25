package com.example.honeybe_spring.service;

import com.example.honeybe_spring.domain.User;
import com.example.honeybe_spring.domain.dto.Login;
import com.example.honeybe_spring.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
// 스프링시큐리티에서 유저를 찾는 메소드 제공
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> byuid = userRepository.findByuid(username);

        return byuid
                .orElseThrow(()->new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
     */

    @Override
    public Login loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> byuid = userRepository.findByuid(username);

        Login login = new Login(byuid.get().getUid(), byuid.get().getPassword());

        return login;
    }

    public void save(User user){
        userRepository.save(user);
    }
}
