package com.viewer.moviesystem.utils;

import cn.hutool.captcha.LineCaptcha;
import com.viewer.moviesystem.domain.properties.CaptchaProperties;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.util.Date;

@Slf4j
@Component
public class CaptchaUtil {
    @Autowired
    private CaptchaProperties cp;

    //一分钟
    private static long VALID_TIME_OUT = 60 * 1000;

    public void getCaptcha(HttpSession session, HttpServletResponse response){
        //生成验证码
        LineCaptcha lineCaptcha = cn.hutool.captcha.CaptchaUtil.createLineCaptcha(cp.getWidth(), cp.getHeight());
        //打印验证码
        String code = lineCaptcha.getCode();
        log.info("Logger生成验证码: "+ code);
        //存储session
        session.setAttribute(cp.getSession().getKey(), code);
        session.setAttribute(cp.getSession().getDate(), new Date());
        System.out.println(lineCaptcha.getCode());
        try {
            //把验证码写到浏览器
            lineCaptcha.write(response.getOutputStream());
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Pragma", "No-cache");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean check(String captcha, HttpSession session){
        System.out.println("用户输入验证码:"+ captcha);
        if (!StringUtils.hasLength(captcha)){
            return false;
        }

        String code = (String)session.getAttribute(cp.getSession().getKey());
        Date date = (Date) session.getAttribute(cp.getSession().getDate());

        if (date==null || (System.currentTimeMillis()-date.getTime())> VALID_TIME_OUT){
            return false;
        }
        //校验captcha是否正确
        return captcha.equalsIgnoreCase(code);
    }
}
