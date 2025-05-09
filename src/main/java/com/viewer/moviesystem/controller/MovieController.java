package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.domain.dto.MovieListDTO;
import com.viewer.moviesystem.domain.vo.MovieListVO;
import com.viewer.moviesystem.service.IMovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {
    @Autowired
    private IMovieService movieService;

    @GetMapping("/getList")
    public TableDataInfo getList(MovieListDTO dto) {
        List<MovieListVO> list = movieService.getList(dto);
        return getTableDataInfo(list);
    }
} 