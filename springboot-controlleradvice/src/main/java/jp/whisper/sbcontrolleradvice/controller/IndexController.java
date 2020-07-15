package jp.whisper.sbcontrolleradvice.controller;

import jp.whisper.sbcontrolleradvice.exception.BusiException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName HellContoller
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/22 21:57
 * @Version 1.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/hello")
    public String hello(){
        return "index";
    }

    @GetMapping("/exception")
    public String exception() throws BusiException {
        throw new BusiException("my exception");
    }

    @GetMapping("/exception2")
    public String exception2() throws Exception {
        throw new Exception("my exception2");
    }
}
