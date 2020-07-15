package jp.whisper.sbthymeleaf.controller;

import jp.whisper.sbthymeleaf.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/20 23:30
 * @Version 1.0
 */
@Controller
public class UserController {

    @GetMapping("/list")
    public String list(Model model){
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setAge(20);
            user.setIndex(i+1);
            user.setUserId("A000" + i);
            user.setUserName("ダミー" + i);

            userList.add(user);
        }

        model.addAttribute("userList", userList);

        return "user_list";
    }
}
