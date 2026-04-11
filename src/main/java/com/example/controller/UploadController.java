package com.example.controller;


import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//@Slf4j
//@RestController
//public class UploadController {
//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("{},{},{}", name, age, file);
//        String originalFilename = file.getOriginalFilename();
//        file.transferTo(new File("d:/" + originalFilename));
//        return Result.success();
//    }
//}
