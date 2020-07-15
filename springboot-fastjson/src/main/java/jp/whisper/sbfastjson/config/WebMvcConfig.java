package jp.whisper.sbfastjson.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/21 16:32
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig {

    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setCharset(Charset.forName("UTF-8"));//default
        fastJsonConfig.setDateFormat("yyyy-MM-dd");

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        return fastJsonHttpMessageConverter;
    }
}
