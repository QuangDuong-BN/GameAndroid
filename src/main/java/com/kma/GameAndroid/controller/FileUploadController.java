package com.kma.GameAndroid.controller;

import com.kma.GameAndroid.imageService.FileUpLoadResponse;
import com.kma.GameAndroid.imageService.FileUploadUtil;
import com.kma.GameAndroid.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("user/uploadfile")
public class FileUploadController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<String> upLoadFile(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) throws IOException {


//        String fileName = userService.getUsernameByToken(request) + "." + getFileExtension(multipartFile);
        String fileName = userService.getUsernameByToken(request);
        long size = multipartFile.getSize();
        FileUploadUtil.saveFile(fileName, multipartFile);
        FileUpLoadResponse fileUpLoadResponese = new FileUpLoadResponse(fileName, "/dowloadFile", size);
        return ResponseEntity.ok("success");
    }

//    public String getFileExtension(MultipartFile multipartFile) {
//        String originalFilename = multipartFile.getOriginalFilename();
//        if (originalFilename != null) {
//            int dotIndex = originalFilename.lastIndexOf(".");
//            if (dotIndex != -1 && dotIndex < originalFilename.length() - 1) {
//                return originalFilename.substring(dotIndex + 1);
//            }
//        }
//        return "";
//    }
}
