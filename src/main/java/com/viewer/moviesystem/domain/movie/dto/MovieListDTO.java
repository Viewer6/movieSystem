package com.viewer.moviesystem.domain.movie.dto;

import com.viewer.moviesystem.domain.dto.PageQueryDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieListDTO extends PageQueryDTO {
    private String movieName;
    private Long categoryId;
    private String director;
    private LocalDate releaseDate;
}