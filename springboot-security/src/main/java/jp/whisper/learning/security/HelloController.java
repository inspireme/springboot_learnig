package jp.whisper.learning.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TDDO
 * @Author whisper
 * @Date 2020/05/04 13:54
 * @Version 1.0
 */
@RestController
public class HelloController {
    /**
     * @Author whisper
     * @Description hello request
     * @Date 14:40 2020/05/04
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }

}
