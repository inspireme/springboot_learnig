package jp.whisper.sbproperties.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/15 22:14
 * @Version 1.0
 */
@Component
@PropertySource("classpath:userconfig.properties")
@ConfigurationProperties(prefix = "testuser")
public class UserConfig2 {
    private String id;

    private String name;

    @Override
    public String toString() {
        return "AppConfig2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
