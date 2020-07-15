package jp.whisper.sbjpa;

import jp.whisper.sbjpa.bean.Project;
import jp.whisper.sbjpa.dao.ProjectDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringbootJpaApplicationTests {

    @Autowired
    ProjectDao projectDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        Project project = new Project();
        project.setManager("whisper2");
        project.setName("aws development2");
        projectDao.save(project);
    }

    @Test
    public void test2(){
        Project project = new Project();
        project.setName("azure development");
        project.setManager("whisper2");
        project.setId(1);
        projectDao.saveAndFlush(project);
    }

    @Test
    public void test3(){
        Optional<Project> projectOptional = projectDao.findById(1);
        System.out.println(projectOptional.get());

        List<Project> all = projectDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
        System.out.println(all);
    }

    @Test
    public void test4(){
        Pageable pageable = PageRequest.of(1, 2);
        Page<Project> page = projectDao.findAll(pageable);

        System.out.println("总记录数>>" + page.getTotalElements());
        System.out.println("当前页记录数>>" + page.getNumberOfElements());
        System.out.println("每页记录数>>" + page.getSize());
        System.out.println("获取总页数>>" + page.getTotalPages());
        System.out.println("查询结果>>" + page.getContent());
        System.out.println("当前页数(从0开始)>>" + page.getNumber());
        System.out.println("是否为页首>>" + page.isFirst());
        System.out.println("是否为页尾>>" + page.isLast());
    }

    @Test
    public void test5(){
        Project project = projectDao.findProjectById(2);
        System.out.println(project);
    }

    @Test
    public void test6(){
        Project project = projectDao.getMaxIdProject();
        System.out.println(project);
    }

    @Test
    public void test7(){
        Project project = new Project();
        project.setManager("manager4");
        project.setName("name4");
        projectDao.addProject(project);
    }

    @Test
    public void test8(){
        projectDao.addProject2("name7", "manager7");
    }
}
