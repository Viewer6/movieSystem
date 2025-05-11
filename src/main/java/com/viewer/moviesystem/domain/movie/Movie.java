package com.viewer.moviesystem.domain.movie;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viewer.moviesystem.domain.BaseEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Movie extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String movieName;
    private Long categoryId;
    private String actors;
    private String director;
    private Integer duration;
    private LocalDate releaseDate;
    private String movieLink;
} 