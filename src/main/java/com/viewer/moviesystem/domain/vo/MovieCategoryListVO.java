package com.viewer.moviesystem.domain.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieCategoryListVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String categoryName;
    private String createBy;
    private LocalDateTime createTime;
} 