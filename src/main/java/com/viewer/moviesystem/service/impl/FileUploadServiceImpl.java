package com.viewer.moviesystem.service.impl;

import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.emuns.ResultCode;
import com.viewer.moviesystem.service.IFileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
public class FileUploadServiceImpl implements IFileUploadService {

    @Value("${file.upload.path:/uploads}")
    private String uploadPath;

    @Override
    public Result<String> uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return Result.fail(ResultCode.FAILED, "请选择要上传的文件");
        }

        // 检查文件类型
        String contentType = file.getContentType();
        if (contentType == null || (!contentType.equals("video/mp4") && !contentType.equals("video/x-matroska"))) {
            return Result.fail(ResultCode.FAILED, "只支持MP4/MKV格式的视频文件");
        }

        // 检查文件大小（500MB）
        if (file.getSize() > 500 * 1024 * 1024) {
            return Result.fail(ResultCode.FAILED, "文件大小不能超过500MB");
        }

        try {
            // 创建上传目录
            Path uploadDir = Paths.get(uploadPath);
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename != null ? originalFilename.substring(originalFilename.lastIndexOf(".")) : ".mp4";
            String newFilename = UUID.randomUUID().toString() + extension;

            // 保存文件
            Path filePath = uploadDir.resolve(newFilename);
            Files.copy(file.getInputStream(), filePath);

            // 返回文件访问URL
            String fileUrl = "/uploads/" + newFilename;
            return Result.success(fileUrl);
        } catch (IOException e) {
            log.error("文件上传失败", e);
            return Result.fail(ResultCode.FAILED, "文件上传失败：" + e.getMessage());
        }
    }
} 