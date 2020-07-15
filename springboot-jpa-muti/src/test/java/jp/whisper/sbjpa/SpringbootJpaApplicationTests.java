package jp.whisper.sbjpa;

import jp.whisper.sbjpa.bean.Project;
import jp.whisper.sbjpa.bean.User;
import jp.whisper.sbjpa.primaryDao.ProjectDao;
import jp.whisper.sbjpa.secondDao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootJpaApplicationTests {

    @Autowired
    ProjectDao projectDao;

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        Project project = new Project();
        project.setManager("whisper000001");
        project.setName("aws development0002");
        projectDao.save(project);

        User user = new User();
        user.setDepartment("dummy0001");
        user.setName("dummyname0002");

        userDao.save(user);
    }

    @Test
    public void test2(){
        System.out.println(projectDao.findAll());
        System.out.println(userDao.findAll());
    }
}
