package com.viewer.moviesystem.domain.news.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewsDetailDTO {
    @NotNull(message = "ID不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
}