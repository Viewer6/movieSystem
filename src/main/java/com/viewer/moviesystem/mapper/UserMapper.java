package com.viewer.moviesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viewer.moviesystem.domain.user.User;
import com.viewer.moviesystem.domain.user.dto.UserListDTO;
import com.viewer.moviesystem.domain.user.vo.UserListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    public List<UserListVO> selectUserList(UserListDTO userListDTO);
}
