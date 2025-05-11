package com.viewer.moviesystem.domain.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserDetailVO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String username;      // 用户名
    private String email;         // 邮箱
    private String password;
    private Integer role;
}
