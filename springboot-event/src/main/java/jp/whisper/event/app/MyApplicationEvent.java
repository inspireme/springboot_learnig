package jp.whisper.event.app;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyApplicationEvent
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 18:00
 * @Version 1.0
 */
public class MyApplicationEvent extends ApplicationEvent {
    private String message;

    public MyApplicationEvent(Object source) {
        super(source);
    }

    public MyApplicationEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
