package jp.whisper.sbfk.controller;

import jp.whisper.sbfk.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/17 0:20
 * @Version 1.0
 */
@Controller
public class UserController {

    @GetMapping("/list")
    public String user(Model model){
        List<User> userList = new ArrayList<User>(){
            {
                add(new User(1, "A000001", "ダミーユーザー①"));
                add(new User(2, "A000002", "ダミーユーザー②"));
                add(new User(3, "A000003", "ダミーユーザー③"));
            }
        };

        model.addAttribute("userList", userList);
        model.addAttribute("content1", "<h1>wellcome to </h1>");
        model.addAttribute("content2", "<h1>the new world!</h1");

        return "userList";
    }
}
