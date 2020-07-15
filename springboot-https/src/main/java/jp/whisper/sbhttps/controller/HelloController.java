package jp.whisper.sbhttps.controller;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/15 18:18
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello/{username}")
    public String hello(@PathVariable(name = "username") Optional<String> name) {
        return name.map(value -> String.format("hello, %s!", value)).orElse("hello , nobody");
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello test";
    }

    @GetMapping("/hello3/{username}")
    public String hello3(@PathVariable("username") String name) {
        Optional<String> nameOpt = Optional.of(name);
        return nameOpt.map(value -> String.format("hello, %s!", value)).orElse("hello , nobody");
    }
}
