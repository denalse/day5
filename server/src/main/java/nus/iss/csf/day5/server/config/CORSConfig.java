package nus.iss.csf.day5.server.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSConfig implements WebMvcConfigurer {

    private String path;
    private String origins;

    public CORSConfig(String p, String o) {
        path = p; // /api/* 
        origins = o; // *

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry
            .addMapping(path)
            .allowedOrigins(origins);
            
    }
    
}
