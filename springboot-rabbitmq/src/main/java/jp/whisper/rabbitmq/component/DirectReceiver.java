package jp.whisper.rabbitmq.component;

import jp.whisper.rabbitmq.config.RabbitDirectConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName DirectReceiver
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/25 17:52
 * @Version 1.0
 */
@Component
public class DirectReceiver {
    @RabbitListener(queues = RabbitDirectConfig.QUEUE_NAME)
    public void handler(String msg){
        System.out.println("message>>>>" + msg);
    }

}
