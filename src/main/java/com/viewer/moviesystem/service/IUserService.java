package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.login.dto.LoginDTO;
import com.viewer.moviesystem.domain.login.dto.RegisterDTO;
import com.viewer.moviesystem.domain.login.vo.LoginVO;
import com.viewer.moviesystem.domain.user.dto.UserEditDTO;
import com.viewer.moviesystem.domain.user.dto.UserListDTO;
import com.viewer.moviesystem.domain.user.vo.UserDetailVO;
import com.viewer.moviesystem.domain.user.vo.UserListVO;

import java.util.List;

public interface IUserService {
    LoginVO login(LoginDTO loginDTO);

    int register(RegisterDTO registerDTO);

    List<UserListVO> getList(UserListDTO userListDTO);

    int alterRole(Long id, String roleCN);

    int alterStatus(Long id);

    int delete(Long id);

    int deleteSelect(String ids);

    UserDetailVO detail(Long id);

    int edit(UserEditDTO userEditDTO);
}
