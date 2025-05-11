package com.viewer.moviesystem.domain.dto;

import lombok.Data;

@Data
public class MovieCategoryListDTO extends PageQueryDTO {
    private String categoryName;
} 