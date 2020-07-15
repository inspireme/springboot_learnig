package jp.whisper.mongo.config;

import jp.whisper.mongo.bean.Project;
import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

/**
 * @ClassName RestConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/10 12:07
 * @Version 1.0
 */
@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setBasePath("/api")
                .setReturnBodyOnCreate(true)
                .setReturnBodyOnUpdate(true);

    }
    
}
