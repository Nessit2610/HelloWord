package com.example.demo.WebConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000") // Thay thế với URL của frontend nếu cần
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
		.allowCredentials(true); // Cho phép gửi cookie
    }
}
