package jp.whisper.mongo;

import jp.whisper.mongo.bean.Project;
import jp.whisper.mongo.dao.ProjectDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class SpringbootMongoApplicationTests {
    @Autowired
    ProjectDao projectDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        Project pro = new Project();
        pro.setId(1);
        pro.setName("dummy project");
        pro.setRemark("the first project!");
        projectDao.save(pro);
    }

    @Test
    public void test2(){
        Project pro = new Project();
        pro.setId(2);
        pro.setName("whisper");
        pro.setRemark("the second project!");
        projectDao.save(pro);
    }

    @Test
    public void test3(){
        List<Project> projects = projectDao.findProjectByNameLike("whisper");
        System.out.println(projects);
    }

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test4(){
        List<Project> projects = mongoTemplate.findAll(Project.class);
        System.out.println(projects);
    }
}
