package com.viewer.moviesystem.domain.news.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class NewsListVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String newsTitle;
    private String newsCategory;
    private String newsContent;
    private LocalDate eventDate;
} 