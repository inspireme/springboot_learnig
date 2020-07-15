package jp.whisper.sbservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("jp.whisper.sbservlet")
public class SpringbootServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServletApplication.class, args);
    }

}
