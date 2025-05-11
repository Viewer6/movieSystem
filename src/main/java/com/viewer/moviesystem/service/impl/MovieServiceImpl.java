package com.viewer.moviesystem.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.viewer.moviesystem.domain.movie.Movie;
import com.viewer.moviesystem.domain.movie.dto.MovieAddDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieDetailDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieEditDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieListDTO;
import com.viewer.moviesystem.domain.movie.vo.MovieDetailVO;
import com.viewer.moviesystem.domain.movie.vo.MovieListVO;
import com.viewer.moviesystem.emuns.ResultCode;
import com.viewer.moviesystem.exception.ServiceException;
import com.viewer.moviesystem.mapper.MovieMapper;
import com.viewer.moviesystem.service.IMovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<MovieListVO> getList(MovieListDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return movieMapper.selectMovieList(dto);
    }

    @Override
    public MovieDetailVO getDetail(MovieDetailDTO dto) {
        Movie movie = movieMapper.selectById(dto.getId());
        if (movie == null) {
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        MovieDetailVO vo = new MovieDetailVO();
        BeanUtils.copyProperties(movie, vo);
        return vo;
    }

    @Override
    public int add(MovieAddDTO dto) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(dto, movie);
        return movieMapper.insert(movie);
    }

    @Override
    public int edit(MovieEditDTO dto) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(dto, movie);
        return movieMapper.updateById(movie);
    }

    @Override
    public int delete(Long id) {
        return movieMapper.deleteById(id);
    }

    @Override
    public int deleteSelect(String ids) {
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<Movie> movies = movieMapper.selectByIds(idList);
        if (CollectionUtil.isEmpty(movies)){
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        return movieMapper.deleteByIds(idList);
    }
} 