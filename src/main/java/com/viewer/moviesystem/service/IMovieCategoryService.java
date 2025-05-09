package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.vo.MovieCategoryListVO;

import java.util.List;

public interface IMovieCategoryService {
    List<MovieCategoryListVO> getList(MovieCategoryListDTO dto);
} 