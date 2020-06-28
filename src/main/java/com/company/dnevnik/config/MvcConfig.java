package com.company.dnevnik.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/mainPage").setViewName("mainPage");
        registry.addViewController("/instruction").setViewName("instruction");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/userInfo").setViewName("userInfo");
    }
}
