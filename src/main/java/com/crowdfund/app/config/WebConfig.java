package com.crowdfund.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","https://warm-kashata-7c4f36.netlify.app/") // Allow requests from your frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
