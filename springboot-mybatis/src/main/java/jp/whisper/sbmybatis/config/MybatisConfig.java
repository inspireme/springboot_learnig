package jp.whisper.sbmybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/03 17:49
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "jp.whisper.sbmybatis.mapper", sqlSessionFactoryRef = "sqlSessionFactoryFirst",
        sqlSessionTemplateRef = "sqlSessionTemplateFisrt")
public class MybatisConfig {
    @Resource(name = "firstDS")
    DataSource dataSource;

    @Bean("sqlSessionFactoryFirst")
    SqlSessionFactory sqlSessionFactoryFirst() {
        SqlSessionFactory sessionFactory = null;
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);
            sessionFactory = sessionFactoryBean.getObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sessionFactory;
    }

    @Bean("sqlSessionTemplateFisrt")
    SqlSessionTemplate sqlSessionTemplateFisrt() {
        return new SqlSessionTemplate(sqlSessionFactoryFirst());
    }
}
