package com.viewer.moviesystem.domain.news.dto;

import com.viewer.moviesystem.domain.dto.PageQueryDTO;
import lombok.Data;

@Data
public class NewsListDTO extends PageQueryDTO {
    private String newsTitle;
} 