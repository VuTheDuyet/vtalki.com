package com.vtalki.vtalki_backend.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get("uploads/teachers");
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        registry.addResourceHandler("/uploads/teachers/**")
                .addResourceLocations("file:" + uploadPath + "/");

        Path courseHomeDir = Paths.get("uploads/coursehome");
        String uploadCourseHomePath = courseHomeDir.toFile().getAbsolutePath();
        registry.addResourceHandler("uploads/coursehome/**")
                .addResourceLocations("file:" + uploadCourseHomePath + "/");
    }
}