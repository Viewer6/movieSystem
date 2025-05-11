package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.dto.MovieCategoryAddDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryDetailDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryEditDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryCountVO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryDetailVO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryListVO;
import com.viewer.moviesystem.domain.vo.MovieDirectorCountVO;

import java.util.List;

public interface IMovieCategoryService {
    List<MovieCategoryListVO> getList(MovieCategoryListDTO dto);
    
    MovieCategoryDetailVO getDetail(MovieCategoryDetailDTO dto);
    
    List<MovieCategoryCountVO> getCategoryCount();
    
    List<MovieDirectorCountVO> getDirectorCount();
    
    int add(MovieCategoryAddDTO dto);
    
    int edit(MovieCategoryEditDTO dto);
    
    int delete(Long id);
    
    int deleteSelect(String ids);
} 