package jp.whisper.sbproperties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/15 22:14
 * @Version 1.0
 */
@Component
public class AppConfig {
    @Value("${app.id}")
    private String appId;

    @Value("${app.name}")
    private String appName;

    @Override
    public String toString() {
        return "AppConfig{" +
                "appId='" + appId + '\'' +
                ", appName='" + appName + '\'' +
                '}';
    }
}
