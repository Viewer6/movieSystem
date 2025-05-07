package com.viewer.moviesystem.domain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Session session;

    @Data
    public static class Session {
        private String key;
        private String date;
    }

}