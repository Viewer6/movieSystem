package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.news.dto.NewsAddDTO;
import com.viewer.moviesystem.domain.news.dto.NewsDetailDTO;
import com.viewer.moviesystem.domain.news.dto.NewsEditDTO;
import com.viewer.moviesystem.domain.news.dto.NewsListDTO;
import com.viewer.moviesystem.domain.news.vo.NewsDetailVO;
import com.viewer.moviesystem.domain.news.vo.NewsListVO;

import java.util.List;

public interface INewsService {
    List<NewsListVO> getList(NewsListDTO dto);
    
    NewsDetailVO getDetail(NewsDetailDTO dto);
    
    int add(NewsAddDTO dto);
    
    int edit(NewsEditDTO dto);
    
    int delete(Long id);
    
    int deleteSelect(String ids);
} 