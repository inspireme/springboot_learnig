package jp.whisper.contoller;

import jp.whisper.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/13 21:56
 * @Version 1.0
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("hello")
    public String hello(){
        return helloService.sayHello();
    }

    @GetMapping("record")
    public List<String> getRecords(){
        return new ArrayList<String>(){
            {
                add("user1");
                add("user2");
            }
        };
    }
}
