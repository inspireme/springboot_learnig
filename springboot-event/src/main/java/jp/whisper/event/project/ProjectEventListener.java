package jp.whisper.event.project;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProjectEventListener
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 15:21
 * @Version 1.0
 */
@Component
public class ProjectEventListener {

    @EventListener
    public void getProjectEvent(ProjectEvent projectEvent){
        System.out.println(String.format("getProjectEvent>>>%s", projectEvent.getSource().toString()));
    }

    @EventListener
    public void getProjectEvent2(ProjectEvent projectEvent){
        System.out.println(String.format("getProjectEvent2>>>%s", projectEvent.getSource().toString()));
    }
}
