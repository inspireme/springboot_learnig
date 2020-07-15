package jp.whisper.learning.firstweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * 起動クラス
 *
 * @author whisper
 */
@SpringBootApplication
@Slf4j
public class SpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);

        log.info("app が成功に起動されました。");
    }
}
