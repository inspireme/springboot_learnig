package jp.whisper.shiro.config.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/20 18:04
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello!!!!";
    }

    @GetMapping("/success")
    public String success(){
        return "login success!";
    }

    @GetMapping("/login")
    public String login(){
        return "please login!";
    }

    @PostMapping("/doLogin")
    public void doLogin(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("login success");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("login failure >>>" + e.getMessage());
        }
    }

}
