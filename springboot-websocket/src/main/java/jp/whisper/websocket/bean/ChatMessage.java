package jp.whisper.websocket.bean;

/**
 * @ClassName ChatMessage
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/21 16:19
 * @Version 1.0
 */
public class ChatMessage {
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
