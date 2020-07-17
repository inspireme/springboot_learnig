package jp.whisper.event.app;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyApplicationListener
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 18:01
 * @Version 1.0
 */
@Component
public class MyApplicationListener2 {

    @EventListener
    public void addApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("addApplicationEvent>>>" + this.getClass().getName());
        System.out.println(applicationEvent.getClass().getName() + "is listened");
        if (applicationEvent instanceof MyApplicationEvent) {
            MyApplicationEvent myApplicationEvent = (MyApplicationEvent) applicationEvent;
            System.out.println("MyApplicationEvent.message is :" + (myApplicationEvent.getMessage()));
        }
    }
}
