package jp.whisper.controller;

import jp.whisper.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/10 0:00
 * @Version 1.0
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hello", produces = "text/html;charset=UTF-8")
    public String hello(){
        return helloService.sayHello();
    }

}
