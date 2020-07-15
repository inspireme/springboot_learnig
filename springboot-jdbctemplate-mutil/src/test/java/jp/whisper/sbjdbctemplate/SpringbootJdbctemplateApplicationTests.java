package jp.whisper.sbjdbctemplate;

import jp.whisper.sbjdbctemplate.bean.User;
import jp.whisper.sbjdbctemplate.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootJdbctemplateApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {

    }

    @Test
    public void test1() {
        User user = new User();
        user.setName("testuser");
        user.setDepartment("department");
        userService.addUser(user);
    }

    @Test
    public void test2(){
        userService.deleteUser(1);
    }

    @Test
    public void test3(){
        User user = new User();
        user.setId(2);
        user.setName("name2");
        user.setDepartment("department2");

        userService.updateUser(user);
    }

    @Test
    public void test4(){
        List userList = userService.getUserList();

        System.out.println(userList);
    }

    @Test
    public void test5(){
        User user = userService.getUserById(2);

        System.out.println(user);
    }


}
