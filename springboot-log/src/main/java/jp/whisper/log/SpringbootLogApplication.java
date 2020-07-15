package jp.whisper.log;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class SpringbootLogApplication {

    public static void main(String[] args) {
        Logger logger = (Logger) LoggerFactory.getLogger(SpringbootLogApplication.class);

        logger.info("ログレベル [INFO] で出力されるログ");
        logger.debug("ログレベル [DEBUG] で出力されるログ");

        SpringApplication.run(SpringbootLogApplication.class, args);
    }

}
