package com.viewer.moviesystem.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieListDTO extends PageQueryDTO {
    private String movieName;
    private Long categoryId;
    private String director;
    private LocalDate releaseDate;
}