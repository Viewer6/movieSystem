package com.viewer.moviesystem.domain.user.dto;

import com.viewer.moviesystem.domain.dto.PageQueryDTO;
import lombok.Data;

@Data
public class UserListDTO extends PageQueryDTO {
    private String title;
}