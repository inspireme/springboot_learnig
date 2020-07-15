package jp.whisper.sbfastjson.controller;

import jp.whisper.sbfastjson.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/21 16:25
 * @Version 1.0
 */
@Controller
public class UserController {

    @GetMapping(path = "/list", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            User user = new User();
            user.setAge(index + 1);
            user.setBirthday(new Date());
            user.setUserId("A0000" + index);
            user.setUserName("ダミー>>" + index);

            userList.add(user);
        }

        return userList;
    }
}
