package jp.whisper.sbjdbctemplate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName JdbcTemplateConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/03 15:05
 * @Version 1.0
 */
@Configuration
public class JdbcTemplateConfig {

    @Bean
    JdbcTemplate jdbcTemplateFirst(@Qualifier("firstDS") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    JdbcTemplate jdbcTemplateSecond(@Qualifier("secondDS") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
