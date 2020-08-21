package jp.whisper.websocket.bean;

/**
 * @ClassName SingleMessage
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/21 19:13
 * @Version 1.0
 */
public class SingleMessage {
    private String from;
    private String content;
    private String to;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
