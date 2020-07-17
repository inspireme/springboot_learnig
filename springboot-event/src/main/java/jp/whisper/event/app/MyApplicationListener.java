package jp.whisper.event.app;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyApplicationListener
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 18:01
 * @Version 1.0
 */
@Component
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(applicationEvent.getClass().getName() + "is listened");
        if (applicationEvent instanceof MyApplicationEvent) {
            MyApplicationEvent myApplicationEvent = (MyApplicationEvent) applicationEvent;
            System.out.println("MyApplicationEvent.message is :" + (myApplicationEvent.getMessage()));
        }
    }
}
