package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.dto.LoginDTO;
import com.viewer.moviesystem.domain.dto.RegisterDTO;

public interface IUserService {
    void login(LoginDTO loginDTO);

    int register(RegisterDTO registerDTO);
}
