package jp.whisper.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @ClassName ActiveMQConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/25 16:39
 * @Version 1.0
 */
@Configuration
public class ActiveMQConfig {

    @Bean
    Queue queue(){
        return new ActiveMQQueue("whisper");
    }
}
