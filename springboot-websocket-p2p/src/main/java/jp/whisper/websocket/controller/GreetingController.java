package jp.whisper.websocket.controller;

import jp.whisper.websocket.bean.PublicMessage;
import jp.whisper.websocket.bean.SingleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @ClassName GreetingController
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/21 16:19
 * @Version 1.0
 */
@Controller
public class GreetingController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(PublicMessage message) throws InterruptedException {
        Thread.sleep(1000);
        message.setContent(message.getContent() + "????????");
        simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, SingleMessage message){
        message.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/queue/singleChat", message);
    }
}
