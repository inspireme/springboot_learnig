package jp.whisper.sbyaml;

import jp.whisper.sbyaml.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootYamlApplicationTests {

    @Autowired
    AppConfig appConfig;

    @Test
    void contextLoads() {
        System.out.println(appConfig.toString());
    }

}
