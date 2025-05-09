package com.viewer.moviesystem.service;

import com.viewer.moviesystem.domain.dto.NewsListDTO;
import com.viewer.moviesystem.domain.vo.NewsListVO;

import java.util.List;

public interface INewsService {
    List<NewsListVO> getList(NewsListDTO dto);
} 