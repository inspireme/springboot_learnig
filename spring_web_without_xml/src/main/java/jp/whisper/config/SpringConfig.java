package jp.whisper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/13 21:32
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "jp.whisper", useDefaultFilters = true,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class SpringConfig {

}
