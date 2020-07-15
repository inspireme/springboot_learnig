package jp.whisper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName Whisper
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 15:15
 * @Version 1.0
 */

@ConfigurationProperties(prefix = "whisper")
public class WhisperConfig {
    private static final String DEFAULT_NAME = "ダミーネーム";
    private static final String DEFAULT_PORT = "8080";

    private String name = DEFAULT_NAME;
    private String port = DEFAULT_PORT;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
