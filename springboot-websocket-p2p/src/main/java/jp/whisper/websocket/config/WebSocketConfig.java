package jp.whisper.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @ClassName WebSocketConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/21 16:08
 * @Version 1.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {// message proxy regist
        registry.enableSimpleBroker("/topic", "/queue");//消息代理前缀
        registry.setApplicationDestinationPrefixes("/app");//请求被代理目标前缀
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/simple-chat").withSockJS();
    }
}
