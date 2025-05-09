package com.viewer.moviesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.viewer.moviesystem.domain.dto.MovieListDTO;
import com.viewer.moviesystem.domain.vo.MovieListVO;
import com.viewer.moviesystem.mapper.MovieMapper;
import com.viewer.moviesystem.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<MovieListVO> getList(MovieListDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return movieMapper.selectMovieList(dto);
    }
} 