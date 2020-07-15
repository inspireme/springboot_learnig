package jp.whisper.sbyaml.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/16 22:07
 * @Version 1.0
 */
@Component
@ConfigurationProperties("app")
public class AppConfig {
    private List<DBInfo> dbConfig;
    private String appName;
    private String version;

    public List<DBInfo> getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(List<DBInfo> dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "dbConfig=" + dbConfig +
                ", appName='" + appName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
