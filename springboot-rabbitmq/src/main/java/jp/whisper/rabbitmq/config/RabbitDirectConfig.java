package jp.whisper.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitDirectConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/25 17:43
 * @Version 1.0
 */
@Configuration
public class RabbitDirectConfig {
    public final static String DIRECT_NAME = "whisper_direct";
    public final static String QUEUE_NAME = "whisper_queue";

    @Bean
    Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_NAME, true, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("whisper");
    }
}
