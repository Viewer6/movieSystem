package com.viewer.moviesystem.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterDTO {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;              // 雪花算法生成的主键ID
    private String username;      // 用户名
    private String password;      // 密码
    @Email(message = "邮箱格式错误")
    @Pattern(regexp = ".*@.*\\..*$", message = "邮箱必须以 @**.** 结尾")  // 确保包含 @ 和 .
    private String email;         // 邮箱
    private Integer role;
}
