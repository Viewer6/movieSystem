package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.dto.LoginDTO;
import com.viewer.moviesystem.domain.dto.RegisterDTO;
import com.viewer.moviesystem.domain.dto.UserListDTO;
import com.viewer.moviesystem.domain.vo.UserDetailVO;
import com.viewer.moviesystem.domain.vo.UserListVO;

import java.util.List;

public interface IUserService {
    void login(LoginDTO loginDTO);

    int register(RegisterDTO registerDTO);

    List<UserListVO> getList(UserListDTO userListDTO);

    int alterRole(Long id, String roleCN);

    int alterStatus(Long id);

    int delete(Long id);

    int deleteSelect(String ids);

    UserDetailVO detail(Long id);
}
