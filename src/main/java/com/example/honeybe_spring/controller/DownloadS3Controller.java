package com.example.honeybe_spring.controller;


import com.example.honeybe_spring.service.DownloadS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DownloadS3Controller {

    @Autowired
    private DownloadS3Service downloadS3Service;

    @GetMapping("/csv_download")
    public ResponseEntity<byte[]> download() throws IOException {
        return downloadS3Service.getObject("tmi_temp_user_data.csv");
    }
}
