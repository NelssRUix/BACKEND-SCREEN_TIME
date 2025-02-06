package com.nelson_ruiz.screen_time.common.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${cors.allowed.origins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Orígenes permitidos
                .allowedMethods("GET", "POST", "PUT","DELETE") // Métodos específicos
                .allowedHeaders("Content-Type", "Authorization", "api-key")// Encabezados específicos
                .exposedHeaders("Content-Disposition") // Exponer encabezados
                .maxAge(3600); // Cache de CORS por 1 hora
    }
}
