package com.viewer.moviesystem.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.viewer.moviesystem.domain.User;
import com.viewer.moviesystem.domain.dto.LoginDTO;
import com.viewer.moviesystem.domain.dto.RegisterDTO;
import com.viewer.moviesystem.emuns.ResultCode;
import com.viewer.moviesystem.exception.ServiceException;
import com.viewer.moviesystem.mapper.LoginMapper;
import com.viewer.moviesystem.service.ILoginService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public void login(LoginDTO loginDTO) {
        User user = loginMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, loginDTO.getUsername())
                .eq(User::getStatus, 1));
        if (user == null){
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        if(!user.getPassword().equals(loginDTO.getPassword())){
            throw new ServiceException(ResultCode.FAILED_LOGIN);
        }

    }

    @Override
    public int register(RegisterDTO registerDTO) {
        List<User> users =
                loginMapper.selectList(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, registerDTO.getUsername()).eq(User::getStatus, 1));
        if(CollectionUtil.isNotEmpty(users)){
            throw new ServiceException(ResultCode.AILED_USER_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        return loginMapper.insert(user);
    }
}
