package com.example.SpringJWT.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

        //모든 Controller 경로에 대해서 localhost:3000의 프론트 쪽에서 요청이 오는 주소를 허용
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:3000");
    }
}
