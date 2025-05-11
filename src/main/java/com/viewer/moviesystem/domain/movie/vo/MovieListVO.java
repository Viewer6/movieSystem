package com.viewer.moviesystem.domain.movie.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MovieListVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String movieName;
    private Long categoryId;
    private String categoryName;
    private String actors;
    private String director;
    private Integer duration;
    private LocalDate releaseDate;
    private String movieLink;
} 