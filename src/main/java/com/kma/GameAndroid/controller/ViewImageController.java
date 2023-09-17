package com.kma.GameAndroid.controller;

import com.kma.GameAndroid.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class ViewImageController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/image")
    public ResponseEntity<Resource> getImage(HttpServletRequest request) {
        try {

            String imageName = userService.getUsernameByToken(request);
            String imagePath = System.getProperty("user.dir") + "/Files-Upload/" + imageName;
            File imageFile = new File(imagePath);

            if (imageFile.exists()) {
                Resource resource = new FileSystemResource(imageFile);

                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

