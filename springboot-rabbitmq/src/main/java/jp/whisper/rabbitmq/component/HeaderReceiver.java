package jp.whisper.rabbitmq.component;

import jp.whisper.rabbitmq.config.RabbitHeaderConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HeaderReceiver
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/26 16:31
 * @Version 1.0
 */
@Configuration
public class HeaderReceiver {
    @RabbitListener(queues = RabbitHeaderConfig.HEADER_QUEUE_ONE)
    public void handler1(byte[] msg) {
        System.out.println(RabbitHeaderConfig.HEADER_QUEUE_ONE + ">>>>>>" + new String(msg));
    }

    @RabbitListener(queues = RabbitHeaderConfig.HEADER_QUEUE_TWO)
    public void handler2(byte[] msg) {
        System.out.println(RabbitHeaderConfig.HEADER_QUEUE_TWO + ">>>>>>" + new String(msg));
    }
}
