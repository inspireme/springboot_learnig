package jp.whisper.sbproperties;

import jp.whisper.sbproperties.config.AppConfig;
import jp.whisper.sbproperties.config.UserConfig2;
import jp.whisper.sbproperties.config.UserConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootPropertiesApplicationTests {

    @Autowired
    AppConfig appConfig;

    @Autowired
    UserConfig userConfig;

    @Autowired
    UserConfig2 userConfig2;

    @Test
    void contextLoads() {
        System.out.println(appConfig.toString());
        System.out.println(userConfig.toString());
        System.out.println(userConfig2.toString());
    }

}
