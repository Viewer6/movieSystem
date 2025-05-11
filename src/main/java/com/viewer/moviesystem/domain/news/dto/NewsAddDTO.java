package com.viewer.moviesystem.domain.news.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsAddDTO {
    @NotBlank(message = "新闻标题不能为空")
    private String newsTitle;
    
    @NotBlank(message = "新闻类别不能为空")
    private String newsCategory;
    
    @NotBlank(message = "新闻内容不能为空")
    private String newsContent;
    
    private LocalDate eventDate;
} 