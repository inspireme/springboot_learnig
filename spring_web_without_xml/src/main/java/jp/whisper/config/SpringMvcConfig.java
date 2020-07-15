package jp.whisper.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import jp.whisper.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @ClassName SpringMvcConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/13 21:32
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = "jp.whisper", useDefaultFilters = false,
        includeFilters = {
            @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Controller.class),
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //TODO このフィルターがないとAutowiredされたserviceがみつかりません
})
public class SpringMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
    }

    @Bean
    MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new FastJsonHttpMessageConverter());
    }
}
