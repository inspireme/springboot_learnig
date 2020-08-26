package jp.whisper.rabbitmq.component;

import jp.whisper.rabbitmq.config.RabbitTopicConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TopicReceiver
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/26 15:55
 * @Version 1.0
 */
@Configuration
public class TopicReceiver {

    @RabbitListener(queues = RabbitTopicConfig.TOPIC_QUEUE_NAME_ONE)
    public void handler1(String msg){
        System.out.println(RabbitTopicConfig.TOPIC_QUEUE_NAME_ONE + ">>>>>" + msg);
    }

    @RabbitListener(queues = RabbitTopicConfig.TOPIC_QUEUE_NAME_TWO)
    public void handler2(String msg){
        System.out.println(RabbitTopicConfig.TOPIC_QUEUE_NAME_TWO + ">>>>>" + msg);
    }

    @RabbitListener(queues = RabbitTopicConfig.TOPIC_QUEUE_NAME_ADMIN)
    public void handler3(String msg){
        System.out.println(RabbitTopicConfig.TOPIC_QUEUE_NAME_ADMIN + ">>>>>" + msg);
    }
}
