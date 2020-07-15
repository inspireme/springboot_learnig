package jp.whisper.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/10 0:01
 * @Version 1.0
 */
@Service
public class HelloService {
    public String sayHello() {
        return "hello , 山崎直人";
    }
}
