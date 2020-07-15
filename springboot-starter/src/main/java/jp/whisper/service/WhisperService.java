package jp.whisper.service;

/**
 * @ClassName WhisperService
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 22:31
 * @Version 1.0
 */
public class WhisperService {
    private String name;
    private String port;

    public String getWhisperConfigInfo(){
        return String.format("name=%s, port=%s", name, port);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
