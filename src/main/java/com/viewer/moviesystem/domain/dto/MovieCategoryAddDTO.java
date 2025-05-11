package com.viewer.moviesystem.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MovieCategoryAddDTO {
    @NotBlank(message = "电影类别名称不能为空")
    private String categoryName;
} 