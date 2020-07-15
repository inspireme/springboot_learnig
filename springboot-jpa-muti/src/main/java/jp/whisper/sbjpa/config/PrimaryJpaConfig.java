package jp.whisper.sbjpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName PrimaryJpaConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/05 17:18
 * @Version 1.0
 */
@Configuration
@EnableJpaRepositories(basePackages = "jp.whisper.sbjpa.primaryDao",
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanFirst",
        transactionManagerRef = "platformTransactionManagerFirst"
)
public class PrimaryJpaConfig {

    @Autowired
    @Qualifier("firstDS")
    DataSource firstDS;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanFirst(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(firstDS).properties(jpaProperties.getProperties())
                .persistenceUnit("firstPu")//本套配置的唯一名
                .packages("jp.whisper.sbjpa.bean")//model所在的位置
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerFirst(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(localContainerEntityManagerFactoryBeanFirst(builder).getObject());
    }

}
