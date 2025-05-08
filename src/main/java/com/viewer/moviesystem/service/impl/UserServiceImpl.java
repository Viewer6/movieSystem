package com.viewer.moviesystem.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.viewer.moviesystem.domain.User;
import com.viewer.moviesystem.domain.dto.LoginDTO;
import com.viewer.moviesystem.domain.dto.RegisterDTO;
import com.viewer.moviesystem.domain.dto.UserListDTO;
import com.viewer.moviesystem.domain.vo.UserListVO;
import com.viewer.moviesystem.emuns.ResultCode;
import com.viewer.moviesystem.exception.ServiceException;
import com.viewer.moviesystem.mapper.UserMapper;
import com.viewer.moviesystem.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void login(LoginDTO loginDTO) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
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
                userMapper.selectList(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, registerDTO.getUsername()));
        if(CollectionUtil.isNotEmpty(users)){
            throw new ServiceException(ResultCode.AILED_USER_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        return userMapper.insert(user);
    }

    @Override
    public List<UserListVO> getList(UserListDTO userListDTO) {
        PageHelper.startPage(userListDTO.getPageNum(), userListDTO.getPageSize());
        return userMapper.selectUserList(userListDTO);
    }

    @Override
    public int alterRole(Long id, String roleCN) {
        User user = userMapper.selectById(id);
        if(user == null){
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        return userMapper.update(new LambdaUpdateWrapper<User>()
                .eq(User::getId, id)
                .set(User::getRole, roleCN.equals("管理员") ? 0 : 1));
    }

    @Override
    public int alterStatus(Long id) {
        User user = userMapper.selectById(id);
        if(user == null){
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        return userMapper.update(new LambdaUpdateWrapper<User>()
                .eq(User::getId, id)
                .set(User::getStatus, user.getStatus() == 0 ? 1 : 0));
    }
}
