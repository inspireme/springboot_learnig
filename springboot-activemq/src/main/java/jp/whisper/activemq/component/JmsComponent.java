package jp.whisper.activemq.component;

import jp.whisper.activemq.bean.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.Queue;

/**
 * @ClassName JmsComponent
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/25 16:42
 * @Version 1.0
 */
@Component
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queue;

    public void send(MyMessage message){
        this.jmsMessagingTemplate.convertAndSend(this.queue, message);
    }

    @JmsListener(destination = "whisper")
    public void receive(MyMessage message){
        System.out.println(message);
    }

}
