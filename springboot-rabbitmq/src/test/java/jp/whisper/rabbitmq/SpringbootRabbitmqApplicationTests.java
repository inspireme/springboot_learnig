package jp.whisper.rabbitmq;

import jp.whisper.rabbitmq.config.RabbitDirectConfig;
import jp.whisper.rabbitmq.config.RabbitFanoutConfig;
import jp.whisper.rabbitmq.config.RabbitHeaderConfig;
import jp.whisper.rabbitmq.config.RabbitTopicConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testDirect(){
        rabbitTemplate.convertAndSend(RabbitDirectConfig.QUEUE_NAME, "hello direct rabbitMQ");
    } 
    
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUT_NAME, null, "hello fanout rabbitMQ");
    }

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "apple.data", "data of apple");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "tomato.data", "data of tomato");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "apple.fruits", "data of apple (admin)");
    }

    @Test
    public void testHeader(){
        Message msg1 = MessageBuilder.withBody("what is your name?".getBytes()).setHeader(RabbitHeaderConfig.HEADER_KEY1, RabbitHeaderConfig.HEADER_VALUE1).build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADER_NAME, null, msg1);

        Message msg2 = MessageBuilder.withBody("how old are you ?".getBytes()).setHeader(RabbitHeaderConfig.HEADER_KEY2, null).build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADER_NAME, null, msg2);

    }

}
