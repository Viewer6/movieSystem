package com.viewer.moviesystem.domain.movieCategory.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieCategoryEditDTO {
    @NotNull(message = "ID不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    
    @NotBlank(message = "电影类别名称不能为空")
    private String categoryName;
} 