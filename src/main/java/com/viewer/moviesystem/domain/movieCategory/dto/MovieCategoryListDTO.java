package com.viewer.moviesystem.domain.movieCategory.dto;

import com.viewer.moviesystem.domain.dto.PageQueryDTO;
import lombok.Data;

@Data
public class MovieCategoryListDTO extends PageQueryDTO {
    private String categoryName;
} 