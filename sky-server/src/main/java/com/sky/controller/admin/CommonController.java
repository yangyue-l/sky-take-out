package com.sky.controller.admin;


import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sky.result.Result;
import com.sky.utils.AliOssUtil;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/admin/common")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception 
     * @throws IOException 
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传：{}",file);
        String filePath;
        try {
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String objectName = UUID.randomUUID().toString() + extension;

            filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return  Result.success(filePath);

        } catch (Exception e) {
            log.error("文件上传失败：{}",e);
        } 
        return Result.error("文件上传失败");
    }

}
