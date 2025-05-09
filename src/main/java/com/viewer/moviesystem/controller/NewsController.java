package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.domain.dto.NewsListDTO;
import com.viewer.moviesystem.domain.vo.NewsListVO;
import com.viewer.moviesystem.service.INewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {
    @Autowired
    private INewsService newsService;

    @GetMapping("/getList")
    public TableDataInfo getList(NewsListDTO dto) {
        List<NewsListVO> list = newsService.getList(dto);
        return getTableDataInfo(list);
    }
} 