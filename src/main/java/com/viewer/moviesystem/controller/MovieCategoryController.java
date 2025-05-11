package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.domain.dto.MovieCategoryAddDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryDetailDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryEditDTO;
import com.viewer.moviesystem.domain.movieCategory.dto.MovieCategoryListDTO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryCountVO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryDetailVO;
import com.viewer.moviesystem.domain.movieCategory.vo.MovieCategoryListVO;
import com.viewer.moviesystem.domain.vo.MovieDirectorCountVO;
import com.viewer.moviesystem.service.IMovieCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movieCategory")
public class MovieCategoryController extends BaseController {
    @Autowired
    private IMovieCategoryService movieCategoryService;

    @PostMapping("/getList")
    public TableDataInfo getList(@RequestBody MovieCategoryListDTO dto) {
        log.info("" + dto.getCategoryName());
        List<MovieCategoryListVO> list = movieCategoryService.getList(dto);
        return getTableDataInfo(list);
    }

    @GetMapping("/getDetail")
    public Result<MovieCategoryDetailVO> getDetail(@RequestParam Long id) {
        MovieCategoryDetailDTO dto = new MovieCategoryDetailDTO();
        dto.setId(id);
        return Result.success(movieCategoryService.getDetail(dto));
    }

    @GetMapping("/category")
    public Result<List<MovieCategoryCountVO>> getCategoryCount() {
        return Result.success(movieCategoryService.getCategoryCount());
    }

    @GetMapping("/director")
    public Result<List<MovieDirectorCountVO>> getDirectorCount() {
        return Result.success(movieCategoryService.getDirectorCount());
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody MovieCategoryAddDTO dto) {
        return getResult(movieCategoryService.add(dto));
    }

    @PutMapping("/edit")
    public Result<Void> edit(@RequestBody MovieCategoryEditDTO dto) {
        return getResult(movieCategoryService.edit(dto));
    }

    @DeleteMapping("/delete")
    public Result<Void> delete(Long id) {
        return getResult(movieCategoryService.delete(id));
    }

    @DeleteMapping("/deleteSelect")
    public Result<Void> deleteSelect(@RequestParam("ids") String ids) {
        return getResult(movieCategoryService.deleteSelect(ids));
    }
} 