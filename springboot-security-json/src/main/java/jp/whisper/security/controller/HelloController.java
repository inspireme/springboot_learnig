package jp.whisper.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/21 12:16
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("admin")
    public String admin(){
        return "hello admin";
    }
}
