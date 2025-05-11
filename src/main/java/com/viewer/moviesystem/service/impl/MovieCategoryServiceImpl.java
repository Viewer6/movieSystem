package com.viewer.moviesystem.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.viewer.moviesystem.domain.movieCategory.MovieCategory;
import com.viewer.moviesystem.domain.dto.MovieCategoryAddDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryDetailDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryEditDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryCountVO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryDetailVO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryListVO;
import com.viewer.moviesystem.domain.vo.MovieDirectorCountVO;
import com.viewer.moviesystem.emuns.ResultCode;
import com.viewer.moviesystem.exception.ServiceException;
import com.viewer.moviesystem.mapper.MovieCategoryMapper;
import com.viewer.moviesystem.service.IMovieCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieCategoryServiceImpl implements IMovieCategoryService {
    @Autowired
    private MovieCategoryMapper movieCategoryMapper;

    @Override
    public List<MovieCategoryListVO> getList(MovieCategoryListDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return movieCategoryMapper.selectMovieCategoryList(dto);
    }

    @Override
    public MovieCategoryDetailVO getDetail(MovieCategoryDetailDTO dto) {
        MovieCategory movieCategory = movieCategoryMapper.selectById(dto.getId());
        if (movieCategory == null) {
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        MovieCategoryDetailVO vo = new MovieCategoryDetailVO();
        BeanUtils.copyProperties(movieCategory, vo);
        return vo;
    }

    @Override
    public List<MovieCategoryCountVO> getCategoryCount() {
        return movieCategoryMapper.selectCategoryCount();
    }

    @Override
    public List<MovieDirectorCountVO> getDirectorCount() {
        return movieCategoryMapper.selectDirectorCount();
    }

    @Override
    public int add(MovieCategoryAddDTO dto) {
        MovieCategory movieCategory = new MovieCategory();
        BeanUtils.copyProperties(dto, movieCategory);
        return movieCategoryMapper.insert(movieCategory);
    }

    @Override
    public int edit(MovieCategoryEditDTO dto) {
        MovieCategory movieCategory = new MovieCategory();
        BeanUtils.copyProperties(dto, movieCategory);
        return movieCategoryMapper.updateById(movieCategory);
    }

    @Override
    public int delete(Long id) {
        return movieCategoryMapper.deleteById(id);
    }

    @Override
    public int deleteSelect(String ids) {
        List<Long> idList = List.of(ids.split(","))
                .stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<MovieCategory> movieCategories = movieCategoryMapper.selectByIds(idList);
        if (CollectionUtil.isEmpty(movieCategories)) {
            throw new ServiceException(ResultCode.FAILED_USER_NOT_EXISTS);
        }
        return movieCategoryMapper.deleteByIds(idList);
    }
} 