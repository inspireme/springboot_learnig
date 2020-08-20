package jp.whisper.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/20 16:18
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user!";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello !!!!";
    }
}
