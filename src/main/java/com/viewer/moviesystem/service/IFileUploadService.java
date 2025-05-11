package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.Result;
import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadService {
    /**
     * 上传文件
     * @param file 要上传的文件
     * @return 上传结果，包含文件访问URL
     */
    Result<String> uploadFile(MultipartFile file);
} 