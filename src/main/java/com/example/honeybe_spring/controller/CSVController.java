package com.example.honeybe_spring.controller;

import com.example.honeybe_spring.service.DownloadS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CSVController {

    @Autowired
    private DownloadS3Service downloadS3Service;

    @GetMapping("/download/user_csv")
    public ResponseEntity<byte[]> download() throws IOException {
        return downloadS3Service.getObject("tmi_temp_user_data.csv");
    }

    @PostMapping("/upload/csv")
    public String upload(@RequestParam("csv") MultipartFile multipartFile) throws IOException{
        downloadS3Service.upload(multipartFile);
        return downloadS3Service.upload(multipartFile);
    }


}
