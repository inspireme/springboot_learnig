package jp.whisper.sbjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/21 0:03
 * @Version 1.0
 */
@Controller
public class UserController {

    @GetMapping("/get/{id}")
    public String getUserInfo(Model model, @PathVariable String id){
        model.addAttribute("id", id);
        model.addAttribute("name", "dummy_name");
        model.addAttribute("remark", "33333");

        return "user";
    }
}
