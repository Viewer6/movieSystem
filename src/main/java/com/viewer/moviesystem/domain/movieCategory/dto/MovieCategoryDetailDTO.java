package com.viewer.moviesystem.domain.movieCategory.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieCategoryDetailDTO {
    @NotNull(message = "ID不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
} 