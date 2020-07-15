package jp.whisper.sbmybatis;

import jp.whisper.sbmybatis.bean.User;
import jp.whisper.sbmybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        User user = userMapper.getUserById(2);
        System.out.println(user);
    }

    @Test
    public void test2(){
        User user = userMapper.getUserById2(3);
        System.out.println(user);
    }



}
