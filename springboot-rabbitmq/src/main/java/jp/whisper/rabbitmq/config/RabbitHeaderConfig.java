package jp.whisper.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RabbitHeaderConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/26 16:02
 * @Version 1.0
 */
@Configuration
public class RabbitHeaderConfig {
    public static final String HEADER_NAME = "whisper_header";
    public static final String HEADER_QUEUE_ONE = "header_queue_1";
    public static final String HEADER_QUEUE_TWO = "header_queue_2";
    public static final String HEADER_KEY2 = "age";
    public static final String HEADER_KEY1 = "name";
    public static final String HEADER_VALUE1 = "whisper";

    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange(HEADER_NAME, true, false);
    }

    @Bean
    Queue headerQueue1(){
        return new Queue(HEADER_QUEUE_ONE);
    }

    @Bean
    Queue headerQueue2(){
        return new Queue(HEADER_QUEUE_TWO);
    }

    @Bean
    //header 中包含 <HEADER_KEY1, HEADER_VALUE1>
    Binding headerBinding1(){
        Map<String, Object> map = new HashMap<>();
        map.put(HEADER_KEY1, HEADER_VALUE1);

        return BindingBuilder.bind(headerQueue1()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    // header 的key中包含HEADER_KEY2
    Binding headerBinding2(){
        return BindingBuilder.bind(headerQueue2()).to(headersExchange()).where(HEADER_KEY2).exists();
    }
}
