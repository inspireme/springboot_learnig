package jp.whisper.sbexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/25 21:50
 * @Version 1.0
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        int i = 1 / 0;

        return "error";
    }
}
