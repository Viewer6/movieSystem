package com.viewer.moviesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viewer.moviesystem.domain.News;
import com.viewer.moviesystem.domain.dto.NewsListDTO;
import com.viewer.moviesystem.domain.vo.NewsListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
    List<NewsListVO> selectNewsList(@Param("dto") NewsListDTO dto);
} 