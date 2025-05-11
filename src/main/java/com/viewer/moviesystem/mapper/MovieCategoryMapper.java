package com.viewer.moviesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viewer.moviesystem.domain.movieCategory.MovieCategory;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryCountVO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryListVO;
import com.viewer.moviesystem.domain.vo.MovieDirectorCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieCategoryMapper extends BaseMapper<MovieCategory> {
    List<MovieCategoryListVO> selectMovieCategoryList(@Param("dto") MovieCategoryListDTO dto);

    @Select("SELECT c.category_name as categoryName, COUNT(m.id) as count " +
            "FROM movie_category c " +
            "LEFT JOIN movie m ON c.id = m.category_id " +
            "GROUP BY c.category_name")
    List<MovieCategoryCountVO> selectCategoryCount();

    @Select("SELECT director, COUNT(*) as count " +
            "FROM movie " +
            "WHERE director IS NOT NULL " +
            "GROUP BY director")
    List<MovieDirectorCountVO> selectDirectorCount();
} 