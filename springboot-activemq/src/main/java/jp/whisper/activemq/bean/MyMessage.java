package jp.whisper.activemq.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName MyMessage
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/25 16:44
 * @Version 1.0
 */
public class MyMessage implements Serializable {
    private String content;
    private Date sendDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "content='" + content + '\'' +
                ", sendDate=" + sendDate +
                '}';
    }
}
