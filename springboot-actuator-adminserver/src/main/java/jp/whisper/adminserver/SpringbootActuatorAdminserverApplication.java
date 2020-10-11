package jp.whisper.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringbootActuatorAdminserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootActuatorAdminserverApplication.class, args);
    }

}
