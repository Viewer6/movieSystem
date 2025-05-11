package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.domain.login.dto.LoginDTO;
import com.viewer.moviesystem.domain.login.dto.RegisterDTO;
import com.viewer.moviesystem.domain.user.dto.UserEditDTO;
import com.viewer.moviesystem.domain.user.dto.UserListDTO;
import com.viewer.moviesystem.domain.login.vo.LoginVO;
import com.viewer.moviesystem.domain.user.vo.UserDetailVO;
import com.viewer.moviesystem.service.impl.UserServiceImpl;
import com.viewer.moviesystem.utils.CaptchaUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/login")
    public LoginVO login(@RequestBody LoginDTO loginDTO){
        log.info("登录用户名: {}, 密码: {}", loginDTO.getUsername(), loginDTO.getPassword());
        return userService.login(loginDTO);
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody @Valid RegisterDTO registerDTO){
        return getResult(userService.register(registerDTO));
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

    @GetMapping("/getList")
    public TableDataInfo getList(UserListDTO userListDTO){
        return getTableDataInfo(userService.getList(userListDTO));
    }

    @PutMapping ("/alterStatus")
    public Result<Void> alterStatus(Long id){
        log.info("修改状态id: {}", id);
        return getResult(userService.alterStatus(id));
    }

    @PostMapping("/alterRole")
    public Result<Void> alterRole(Long id, String roleCN){
        return getResult(userService.alterRole(id, roleCN));
    }

    @DeleteMapping("/delete")
    public Result<Void> delete(Long id){
        return getResult(userService.delete(id));
    }

    @DeleteMapping("/deleteSelect")
    public Result<Void> deleteSelect(@RequestParam("ids") String ids){
        return getResult(userService.deleteSelect(ids));
    }

    @GetMapping("/getById")
    public UserDetailVO detail(Long id){
        return userService.detail(id);
    }

    @PutMapping("/edit")
    public Result<Void> edit(@RequestBody UserEditDTO userEditDTO){
        return getResult(userService.edit(userEditDTO));
    }
}
