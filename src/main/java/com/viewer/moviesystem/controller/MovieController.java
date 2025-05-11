package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.domain.movie.dto.MovieAddDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieDetailDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieEditDTO;
import com.viewer.moviesystem.domain.movie.dto.MovieListDTO;
import com.viewer.moviesystem.domain.movie.vo.MovieDetailVO;
import com.viewer.moviesystem.domain.movie.vo.MovieListVO;
import com.viewer.moviesystem.service.IMovieService;
import com.viewer.moviesystem.service.IFileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController {
    @Autowired
    private IMovieService movieService;

    @Autowired
    private IFileUploadService fileUploadService;

    @PostMapping("/getList")
    public TableDataInfo getList(@RequestBody MovieListDTO dto) {
        log.info("" + dto.getMovieName());
        List<MovieListVO> list = movieService.getList(dto);
        return getTableDataInfo(list);
    }

    @GetMapping("/getDetail")
    public Result<MovieDetailVO> getDetail(@RequestParam Long id) {
        MovieDetailDTO dto = new MovieDetailDTO();
        dto.setId(id);
        return Result.success(movieService.getDetail(dto));
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody MovieAddDTO dto) {
        return getResult(movieService.add(dto));
    }

    @PutMapping("/edit")
    public Result<Void> edit(@RequestBody MovieEditDTO dto) {
        return getResult(movieService.edit(dto));
    }

    @DeleteMapping("/delete")
    public Result<Void> delete(Long id) {
        return getResult(movieService.delete(id));
    }

    @DeleteMapping("/deleteSelect")
    public Result<Void> deleteSelect(@RequestParam("ids") String ids) {
        return getResult(movieService.deleteSelect(ids));
    }

    @PostMapping("/upload")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) {
        return fileUploadService.uploadFile(file);
    }
}