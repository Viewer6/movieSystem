package com.viewer.moviesystem.domain.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viewer.moviesystem.domain.BaseEntity;
import lombok.Data;

@Data
public class User extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;              // 雪花算法生成的主键ID
    private String username;      // 用户名
    private String password;      // 密码
    private String email;         // 邮箱
    private Integer role;         // 角色（0-管理员，1-普通用户）
    private Integer status;       // 状态（0-禁用，1-正常）

}
