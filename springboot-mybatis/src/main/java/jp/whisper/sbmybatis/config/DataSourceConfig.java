package jp.whisper.sbmybatis.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/03 17:50
 * @Version 1.0
 */
@Configuration
public class DataSourceConfig {
    @Bean("firstDS")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    DataSource firstDS() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("secondDS")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    DataSource secondDS() {
        return DruidDataSourceBuilder.create().build();
    }
}
