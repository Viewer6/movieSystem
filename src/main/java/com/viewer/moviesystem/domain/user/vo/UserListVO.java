package com.viewer.moviesystem.domain.user.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserListVO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;              // 雪花算法生成的主键ID
    private String username;      // 用户名
    private String password;      // 密码
    private String email;         // 邮箱
    private Integer role;         // 角色（0-管理员，1-普通用户）
    private String roleCN;
    private Integer status;       // 状态（0-禁用，1-正常）

    public String getRoleCN() {
        if (role == 0) return "管理员";
        else if (role == 1) return "普通用户";
        else return "超级管理员";
    }
}
