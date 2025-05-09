package com.viewer.moviesystem.domain.vo;

import lombok.Data;

@Data
public class UserDetailVO {
    private String username;      // 用户名
    private String email;         // 邮箱
    private String password;
}
