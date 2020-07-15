package jp.whisper.config;

import jp.whisper.service.WhisperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WhisperServiceAutoConfiguration
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 22:32
 * @Version 1.0
 */

/**
 @Configuration 标识其为配置类
 @EnableConfigurationProperties 让@ConfigurationProperties生效，并讲属性读取到WhisperConfig.class中
 @ConditionalOnClass 当WhisperService class存在的情况下，后面的@Bean等配置才会生效
 **/
@Configuration
@EnableConfigurationProperties(WhisperConfig.class)
@ConditionalOnClass(WhisperService.class)
public class WhisperServiceAutoConfiguration {

    @Autowired
    WhisperConfig whisperConfig;

    @Bean
    WhisperService whisperService(){
        WhisperService whisperService = new WhisperService();
        whisperService.setName(whisperConfig.getName());
        whisperService.setPort(whisperConfig.getPort());

        return whisperService;
    }
}
