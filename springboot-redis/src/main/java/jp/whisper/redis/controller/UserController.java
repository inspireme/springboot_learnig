package jp.whisper.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/05 22:59
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/register")
    public String registerUser(){

        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        stringValueOperations.set("testuser", "welldone!");

        return "success";
    }

    @GetMapping("detail")
    public String userDetail(){
        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        String s = stringValueOperations.get("testuser");
        System.out.println(s);

        return s;
    }
}
