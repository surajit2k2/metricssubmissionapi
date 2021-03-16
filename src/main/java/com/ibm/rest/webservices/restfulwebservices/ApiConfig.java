package com.ibm.rest.webservices.restfulwebservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfig {
    private static final Logger log = LoggerFactory.getLogger(ApiConfig.class);
    //cross origin 
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                log.info("adding cors support");
                registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("OPTIONS", "HEAD",
                        "GET", "PUT", "POST", "PATCH");
            }
        };
    }
}