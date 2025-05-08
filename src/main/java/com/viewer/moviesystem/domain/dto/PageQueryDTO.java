package com.viewer.moviesystem.domain.dto;

import lombok.Data;

@Data
public class PageQueryDTO {

    private Integer pageSize = 5;

    private Integer pageNum = 1;
}
