package com.viewer.moviesystem.domain.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class LoginDTO {
    @NotNull
    private String username;      // 用户名
    @NotNull
    private String password;      // 密码
}
