package com.viewer.moviesystem.controller;

import cn.hutool.captcha.LineCaptcha;
import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.domain.dto.LoginDTO;
import com.viewer.moviesystem.domain.dto.RegisterDTO;
import com.viewer.moviesystem.domain.properties.CaptchaProperties;
import com.viewer.moviesystem.service.impl.LoginServiceImpl;
import com.viewer.moviesystem.utils.CaptchaUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;

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

    @Autowired
    private CaptchaUtil captchaUtil;
    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response){
        captchaUtil.getCaptcha(session, response);
    }

    @RequestMapping("/check")
    public Boolean check(String captcha, HttpSession session){
        return captchaUtil.check(captcha, session);
    }
}
