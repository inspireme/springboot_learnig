package jp.whisper.sbcors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/25 23:43
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOrigins("http://localhost:8081").
                allowedMethods("*").
                allowedHeaders("*").
                maxAge(30 * 1000L);
    }
}
