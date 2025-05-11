package com.viewer.moviesystem.domain.login.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoginVO {
    private Integer role;
    private String roleCN;
    private String username;

    public LoginVO(){}

    public LoginVO(Integer role, String username){
        this.role = role;
        this.username = username;
    }

    public String getRoleCN() {
        if (role == 0) return "管理员";
        else if (role == 1) return "普通用户";
        else return "超级管理员";
    }
}
