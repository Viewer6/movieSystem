package com.viewer.moviesystem.domain.news;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viewer.moviesystem.domain.BaseEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class News extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String newsTitle;
    private String newsCategory;
    private String newsContent;
    private LocalDate eventDate;
} 