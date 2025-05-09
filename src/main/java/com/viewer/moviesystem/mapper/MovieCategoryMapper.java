package com.viewer.moviesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viewer.moviesystem.domain.MovieCategory;
import com.viewer.moviesystem.domain.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.vo.MovieCategoryListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieCategoryMapper extends BaseMapper<MovieCategory> {
    List<MovieCategoryListVO> selectMovieCategoryList(@Param("dto") MovieCategoryListDTO dto);
} 