package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.dto.MovieListDTO;
import com.viewer.moviesystem.domain.vo.MovieListVO;

import java.util.List;

public interface IMovieService {
    List<MovieListVO> getList(MovieListDTO dto);
} 