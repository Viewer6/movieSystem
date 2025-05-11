package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.movie.dto.MovieAddDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieDetailDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieEditDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieListDTO;
import com.viewer.moviesystem.domain.movie.vo.MovieDetailVO;
import com.viewer.moviesystem.domain.movie.vo.MovieListVO;

import java.util.List;

public interface IMovieService {
    List<MovieListVO> getList(MovieListDTO dto);
    int add(MovieAddDTO dto);
    int edit(MovieEditDTO dto);
    int delete(Long id);
    int deleteSelect(String ids);

    MovieDetailVO getDetail(MovieDetailDTO dto);
} 