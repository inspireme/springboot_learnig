package jp.whisper.websocket.controller;

import jp.whisper.websocket.bean.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * @ClassName GreetingController
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/21 16:19
 * @Version 1.0
 */
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings") //topic 为代理前缀
    public ChatMessage greeting(ChatMessage message) throws InterruptedException {
        Thread.sleep(1000); // simulated delay
        message.setContent(message.getContent() + "!!!!!!!!");
        return message;
    }

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello2")
    public void greeting2(ChatMessage message) throws InterruptedException {
        Thread.sleep(1000);
        message.setContent(message.getContent() + "????????");
        simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }
}
