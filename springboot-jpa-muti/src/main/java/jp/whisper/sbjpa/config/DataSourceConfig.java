package jp.whisper.sbjpa.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/05 17:15
 * @Version 1.0
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first")
    DataSource firstDS(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.second")
    DataSource secondDS(){
        return DruidDataSourceBuilder.create().build();
    }
}
