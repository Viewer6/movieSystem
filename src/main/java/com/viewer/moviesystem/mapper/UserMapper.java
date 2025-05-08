package com.viewer.moviesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viewer.moviesystem.domain.User;
import com.viewer.moviesystem.domain.dto.UserListDTO;
import com.viewer.moviesystem.domain.vo.UserListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public List<UserListVO> selectUserList(UserListDTO userListDTO);
}
