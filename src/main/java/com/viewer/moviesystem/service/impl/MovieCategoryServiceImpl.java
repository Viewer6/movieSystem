package com.viewer.moviesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.viewer.moviesystem.domain.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.vo.MovieCategoryListVO;
import com.viewer.moviesystem.mapper.MovieCategoryMapper;
import com.viewer.moviesystem.service.IMovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCategoryServiceImpl implements IMovieCategoryService {
    @Autowired
    private MovieCategoryMapper movieCategoryMapper;

    @Override
    public List<MovieCategoryListVO> getList(MovieCategoryListDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return movieCategoryMapper.selectMovieCategoryList(dto);
    }
} 