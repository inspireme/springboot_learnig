package jp.whisper.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitTopicConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/26 15:34
 * @Version 1.0
 */
@Configuration
public class RabbitTopicConfig {
    public static final String TOPIC_NAME = "whisper_topic";
    public static final String TOPIC_QUEUE_NAME_ONE = "topic_queue_one";
    public static final String TOPIC_QUEUE_NAME_TWO = "topic_queue_two";
    public static final String TOPIC_QUEUE_NAME_ADMIN = "topic_queue_admin";

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_NAME, true, false);
    }

    @Bean
    Queue queueTopic1(){
        return new Queue(TOPIC_QUEUE_NAME_ONE);
    }

    @Bean
    Queue queueTopic2(){
        return new Queue(TOPIC_QUEUE_NAME_TWO);
    }

    @Bean
    Queue queueTopicAdmin(){
        return new Queue(TOPIC_QUEUE_NAME_ADMIN);
    }

    @Bean
    Binding topic1Binding(){
        return BindingBuilder.bind(queueTopic1()).to(topicExchange()).with("apple.#");
    }

    @Bean
    Binding topic2Binding(){
        return BindingBuilder.bind(queueTopic2()).to(topicExchange()).with("orange.#");
    }

    @Bean
    Binding topic3Binding(){
        return BindingBuilder.bind(queueTopicAdmin()).to(topicExchange()).with("#.fruits.#");
    }

}
