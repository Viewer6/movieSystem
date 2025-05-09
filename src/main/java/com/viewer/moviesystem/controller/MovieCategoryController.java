package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.domain.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.vo.MovieCategoryListVO;
import com.viewer.moviesystem.service.IMovieCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movieCategory")
public class MovieCategoryController extends BaseController {
    @Autowired
    private IMovieCategoryService movieCategoryService;

    @GetMapping("/getList")
    public TableDataInfo getList(MovieCategoryListDTO dto) {
        List<MovieCategoryListVO> list = movieCategoryService.getList(dto);
        return getTableDataInfo(list);
    }
} 