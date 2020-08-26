package jp.whisper.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName RabbitFanoutConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/26 15:17
 * @Version 1.0
 */
@Configuration
public class RabbitFanoutConfig {
    public static final String FANOUT_NAME = "whisper_fanout";
    public static final String FANOUT_QUEUE_NAME_ONE = "fanout_queue_one";
    public static final String FANOUT_QUEUE_NAME_TWO = "fanout_queue_two";

    @Bean
    Queue queueOne(){
        return new Queue(FANOUT_QUEUE_NAME_ONE);
    }

    @Bean
    Queue queueTwo(){
        return new Queue(FANOUT_QUEUE_NAME_TWO);
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_NAME, true, false);
    }

    @Bean
    Binding bindingOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindingTwo(){
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }
}
