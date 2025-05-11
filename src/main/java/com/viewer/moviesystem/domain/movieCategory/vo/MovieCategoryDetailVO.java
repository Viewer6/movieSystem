package com.viewer.moviesystem.domain.movieCategory.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieCategoryDetailVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    
    private String categoryName;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
} 