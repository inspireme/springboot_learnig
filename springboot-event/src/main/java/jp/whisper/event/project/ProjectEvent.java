package jp.whisper.event.project;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName ProjectEvent
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 15:06
 * @Version 1.0
 */
public class ProjectEvent extends ApplicationEvent {
    public ProjectEvent(Project source) {
        super(source);
    }
}
