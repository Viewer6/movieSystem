package com.viewer.moviesystem.domain.news.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsEditDTO {
    @NotNull(message = "ID不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    
    @NotBlank(message = "新闻标题不能为空")
    private String newsTitle;
    
    @NotBlank(message = "新闻类别不能为空")
    private String newsCategory;
    
    @NotBlank(message = "新闻内容不能为空")
    private String newsContent;
    
    private LocalDate eventDate;
} 