package com.viewer.moviesystem.domain.movieCategory;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.viewer.moviesystem.domain.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieCategory extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String categoryName;

} 