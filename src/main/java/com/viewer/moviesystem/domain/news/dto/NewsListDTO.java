package com.viewer.moviesystem.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsListDTO extends PageQueryDTO {
    private String newsTitle;
} 