package jp.whisper.activemq;

import jp.whisper.activemq.bean.MyMessage;
import jp.whisper.activemq.component.JmsComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringbootActivemqApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    JmsComponent jmsComponent;

    @Test
    public void testJms(){
        MyMessage message = new MyMessage();
        message.setContent("hello whisper!!!!");
        message.setSendDate(new Date());
        jmsComponent.send(message);
    }
}
