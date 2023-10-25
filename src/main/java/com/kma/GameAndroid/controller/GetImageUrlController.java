package com.kma.GameAndroid.controller;

import com.kma.GameAndroid.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class GetImageUrlController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/getimageurl")
    public ResponseEntity<String> getUrlImage(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getImageUrl(request));
    }
}

