package com.viewer.moviesystem.domain.movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieAddDTO {
    @NotBlank(message = "电影名称不能为空")
    private String movieName;
    
    @NotNull(message = "电影类别不能为空")
    private Long categoryId;
    
    private String actors;
    
    private String director;
    
    private Integer duration;
    
    private LocalDate releaseDate;
    
    private String movieLink;
} 