package com.viewer.moviesystem.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.viewer.moviesystem.domain.news.News;
import com.viewer.moviesystem.domain.news.dto.NewsAddDTO;
import com.viewer.moviesystem.domain.news.dto.NewsDetailDTO;
import com.viewer.moviesystem.domain.news.dto.NewsEditDTO;
import com.viewer.moviesystem.domain.news.dto.NewsListDTO;
import com.viewer.moviesystem.domain.news.vo.NewsDetailVO;
import com.viewer.moviesystem.domain.news.vo.NewsListVO;
import com.viewer.moviesystem.emuns.ResultCode;
import com.viewer.moviesystem.exception.ServiceException;
import com.viewer.moviesystem.mapper.NewsMapper;
import com.viewer.moviesystem.service.INewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<NewsListVO> getList(NewsListDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return newsMapper.selectNewsList(dto);
    }

    @Override
    public NewsDetailVO getDetail(NewsDetailDTO dto) {
        News news = newsMapper.selectById(dto.getId());
        if (news == null) {
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        NewsDetailVO vo = new NewsDetailVO();
        BeanUtils.copyProperties(news, vo);
        return vo;
    }

    @Override
    public int add(NewsAddDTO dto) {
        News news = new News();
        BeanUtils.copyProperties(dto, news);
        return newsMapper.insert(news);
    }

    @Override
    public int edit(NewsEditDTO dto) {
        News news = new News();
        BeanUtils.copyProperties(dto, news);
        return newsMapper.updateById(news);
    }

    @Override
    public int delete(Long id) {
        return newsMapper.deleteById(id);
    }

    @Override
    public int deleteSelect(String ids) {
        List<Long> idList = List.of(ids.split(","))
                .stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<News> newsList = newsMapper.selectByIds(idList);
        if (CollectionUtil.isEmpty(newsList)) {
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        return newsMapper.deleteByIds(idList);
    }
} 