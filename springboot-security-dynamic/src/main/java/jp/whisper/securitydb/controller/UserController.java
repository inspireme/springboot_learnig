package jp.whisper.securitydb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/19 17:01
 * @Version 1.0
 */
@RestController
public class UserController {

    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user";
    }

    @GetMapping("/dba/hello")
    public String dba(){
        return "hello dba!";
    }
}
