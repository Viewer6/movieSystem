package com.viewer.moviesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viewer.moviesystem.domain.Movie;
import com.viewer.moviesystem.domain.dto.MovieListDTO;
import com.viewer.moviesystem.domain.vo.MovieListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper extends BaseMapper<Movie> {
    List<MovieListVO> selectMovieList(@Param("dto") MovieListDTO dto);
} 