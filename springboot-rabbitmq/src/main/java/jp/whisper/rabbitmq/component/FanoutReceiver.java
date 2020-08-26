package jp.whisper.rabbitmq.component;

import jp.whisper.rabbitmq.config.RabbitFanoutConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FanoutReceiver
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/26 15:26
 * @Version 1.0
 */
@Configuration
public class FanoutReceiver {
    @RabbitListener(queues = RabbitFanoutConfig.FANOUT_QUEUE_NAME_ONE)
    public void handlerOne(String msg){
        System.out.println(RabbitFanoutConfig.FANOUT_QUEUE_NAME_ONE + ">>>>" + msg);
    }

    @RabbitListener(queues = RabbitFanoutConfig.FANOUT_QUEUE_NAME_TWO)
    public void handlerTwo(String msg){
        System.out.println(RabbitFanoutConfig.FANOUT_QUEUE_NAME_TWO + ">>>>" + msg);
    }
}
