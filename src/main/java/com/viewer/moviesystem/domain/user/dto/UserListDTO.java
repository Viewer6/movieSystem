package com.viewer.moviesystem.domain.dto;

import lombok.Data;

@Data
public class UserListDTO extends PageQueryDTO {
    private String title;
}