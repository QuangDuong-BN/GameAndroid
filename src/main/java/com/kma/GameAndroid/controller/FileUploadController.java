package com.kma.GameAndroid.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kma.GameAndroid.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("user")
public class FileUploadController {

    @Autowired
    private UserService userService;

    @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @PostMapping("/setimage")
    public String uploadImage(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        try {
            Cloudinary cloudinary = new Cloudinary("cloudinary://" + apiKey + ":" + apiSecret + "@" + cloudName);
            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            // Lấy URL của ảnh tải lên từ kết quả
            String imageUrl = (String) result.get("url");
            userService.setUrlImage(request, imageUrl);

            return imageUrl; // Chuyển hướng sau khi tải lên thành công
        } catch (IOException e) {
            // Xử lý lỗi tải lên ảnh
            return "redirect:/error";
        }
    }
//    @PostMapping()
//    public ResponseEntity<String> upLoadFile(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) throws IOException {
//
//
////        String fileName = userService.getUsernameByToken(request) + "." + getFileExtension(multipartFile);
//        String fileName = userService.getUsernameByToken(request);
//        long size = multipartFile.getSize();
//        FileUploadUtil.saveFile(fileName, multipartFile);
//        FileUpLoadResponse fileUpLoadResponese = new FileUpLoadResponse(fileName, "/dowloadFile", size);
//        return ResponseEntity.ok("success");
//    }

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
