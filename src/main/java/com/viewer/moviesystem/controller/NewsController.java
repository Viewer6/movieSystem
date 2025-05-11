package com.viewer.moviesystem.controller;

import com.viewer.moviesystem.domain.Result;
import com.viewer.moviesystem.domain.TableDataInfo;
import com.viewer.moviesystem.domain.news.dto.NewsAddDTO;
import com.viewer.moviesystem.domain.news.dto.NewsDetailDTO;
import com.viewer.moviesystem.domain.news.dto.NewsEditDTO;
import com.viewer.moviesystem.domain.news.dto.NewsListDTO;
import com.viewer.moviesystem.domain.news.vo.NewsDetailVO;
import com.viewer.moviesystem.domain.news.vo.NewsListVO;
import com.viewer.moviesystem.service.INewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {
    @Autowired
    private INewsService newsService;

    @PostMapping("/getList")
    public TableDataInfo getList(@RequestBody NewsListDTO dto) {
        log.info("" + dto.getNewsTitle());
        List<NewsListVO> list = newsService.getList(dto);
        return getTableDataInfo(list);
    }

    @GetMapping("/getDetail")
    public NewsDetailVO getDetail(@RequestParam Long id) {
        NewsDetailDTO dto = new NewsDetailDTO();
        dto.setId(id);
        return newsService.getDetail(dto);
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody NewsAddDTO dto) {
        return getResult(newsService.add(dto));
    }

    @PutMapping("/edit")
    public Result<Void> edit(@RequestBody NewsEditDTO dto) {
        return getResult(newsService.edit(dto));
    }

    @DeleteMapping("/delete")
    public Result<Void> delete(Long id) {
        return getResult(newsService.delete(id));
    }

    @DeleteMapping("/deleteSelect")
    public Result<Void> deleteSelect(@RequestParam("ids") String ids) {
        return getResult(newsService.deleteSelect(ids));
    }
} 