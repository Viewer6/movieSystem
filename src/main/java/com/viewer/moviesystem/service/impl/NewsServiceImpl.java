package com.viewer.moviesystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.viewer.moviesystem.domain.dto.NewsListDTO;
import com.viewer.moviesystem.domain.vo.NewsListVO;
import com.viewer.moviesystem.mapper.NewsMapper;
import com.viewer.moviesystem.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<NewsListVO> getList(NewsListDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return newsMapper.selectNewsList(dto);
    }
} 