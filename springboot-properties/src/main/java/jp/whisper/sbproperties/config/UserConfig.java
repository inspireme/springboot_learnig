package jp.whisper.sbproperties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/15 22:13
 * @Version 1.0
 */
@Component
@PropertySource("classpath:userconfig.properties")
public class UserConfig {
    @Value("${testuser.id}")
    private String userId;

    @Value("${testuser.name}")
    private String userName;

    @Override
    public String toString() {
        return "UserConfig{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
