package jp.whisper.sbcors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName hellocontroller
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/25 23:24
 * @Version 1.0
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "index";
    }
}
