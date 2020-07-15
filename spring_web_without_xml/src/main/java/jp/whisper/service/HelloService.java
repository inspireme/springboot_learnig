package jp.whisper.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/13 22:07
 * @Version 1.0
 */
@Service
public class HelloService {
    public String sayHello() {
        return "hello without xml!";
    }
}
