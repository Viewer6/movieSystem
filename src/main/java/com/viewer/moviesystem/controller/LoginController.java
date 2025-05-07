package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.domain.dto.LoginDTO;
import com.viewer.moviesystem.domain.dto.RegisterDTO;
import com.viewer.moviesystem.service.impl.LoginServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class LoginController extends BaseController{
    @Autowired
    private LoginServiceImpl loginService;


    @PostMapping("/login")
    public void login(@RequestBody LoginDTO loginDTO){
        log.info("登录用户名: {}, 密码: {}", loginDTO.getUsername(), loginDTO.getPassword());
        loginService.login(loginDTO);
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody @Valid RegisterDTO registerDTO){
        return getResult(loginService.register(registerDTO));
    }
}
