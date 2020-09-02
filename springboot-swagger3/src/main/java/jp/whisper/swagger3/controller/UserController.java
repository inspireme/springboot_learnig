package jp.whisper.swagger3.controller;

import io.swagger.annotations.*;
import jp.whisper.swagger3.bean.User;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/31 19:20
 * @Version 1.0
 */
@RestController
@Api(tags = "user data interface")
public class UserController {
    @ApiOperation(value = "ユーザー検索", notes = "ユーザーIDでユーザー情報を取得する")
    @ApiImplicitParam(name = "id", value = "ユーザーID", required = true, defaultValue = "99")
    @GetMapping("/user")
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "ユーザー削除", notes = "ユーザーIDでユーザー情報を削除する")
    @ApiImplicitParam(name = "id", value = "ユーザーid", required = true, defaultValue = "99")
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功"),
            @ApiResponse(code = 500, message = "删除失败")
    })
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        System.out.println("deleteUserById:" + id);
    }

    @PutMapping("/user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ユーザーID", required = true, defaultValue = "99"),
            @ApiImplicitParam(name = "username", value = "ユーザー名", required = true, defaultValue = "whisper")
    })
    @ApiOperation(value = "ユーザー情報更新", notes = "指定されたユーザーIDでユーザー情報を更新する")
//    @ApiIgnore
    public User updateUsernameById(String username, Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @PostMapping("/user")
    @ApiOperation(value = "ユーザー追加", notes = "ユーザー情報を追加するIF")
    public User addUser(@RequestBody User user) {
        return user;
    }
}