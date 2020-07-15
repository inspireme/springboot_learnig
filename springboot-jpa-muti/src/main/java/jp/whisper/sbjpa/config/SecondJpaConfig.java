package jp.whisper.sbjpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName SecondJpaConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/05 17:18
 * @Version 1.0
 */
@Configuration
@EnableJpaRepositories(basePackages = "jp.whisper.sbjpa.secondDao",
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanSecond",
        transactionManagerRef = "platformTransactionManagerSecond"
)
public class SecondJpaConfig {

    @Autowired
    @Qualifier("secondDS")
    DataSource secondDS;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanSecond(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(secondDS).properties(jpaProperties.getProperties())
                .persistenceUnit("secondPu")//本套配置的唯一名
                .packages("jp.whisper.sbjpa.bean")//model所在的位置
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerSecond(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(localContainerEntityManagerFactoryBeanSecond(builder).getObject());
    }

}
