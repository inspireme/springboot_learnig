package jp.whisper.sbcache;

import jp.whisper.sbcache.bean.Project;
import jp.whisper.sbcache.service.ProjectService;
import jp.whisper.sbcache.service.ProjectService2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootEhcacheApplicationTests {

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectService2 projectService2;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetProjectById(){
        Project prj = projectService.getProjectById(1);
        System.out.println(prj);

        Project prj2 = projectService.getProjectById(1);
        System.out.println(prj2);

        Project prj3 = projectService.getProjectById(2);
        System.out.println(prj3);
    }

    @Test
    public void testDeleteProjectById(){
        Project prj = projectService.getProjectById(1);
        System.out.println(prj);

        projectService.deleteProjectById(1);

        Project prj2 = projectService.getProjectById(1);
        System.out.println(prj2);
    }

    @Test
    public void testUpdateProject(){
        Project prj = projectService.getProjectById(1);
        System.out.println(prj);

        Project newPrj = projectService.updateProject(prj);
        System.out.println(newPrj);

        Project prj2 = projectService.getProjectById(1);
        System.out.println(prj2);
    }

    @Test
    public void testGetProjectById2(){
        Project prj = projectService2.getProjectById(1);
        System.out.println(prj);

        Project prj2 = projectService2.getProjectById(1);
        System.out.println(prj2);

        Project prj3 = projectService2.getProjectById(2);
        System.out.println(prj3);
    }

    @Test
    public void testDeleteProjectById2(){
        Project prj = projectService2.getProjectById(1);
        System.out.println(prj);

        projectService2.deleteProjectById(1);

        Project prj2 = projectService2.getProjectById(1);
        System.out.println(prj2);
    }

    @Test
    public void testUpdateProject2(){
        Project prj = projectService2.getProjectById(1);
        System.out.println(prj);

        Project newPrj = projectService2.updateProject(prj);
        System.out.println(newPrj);

        Project prj2 = projectService2.getProjectById(1);
        System.out.println(prj2);
    }
}
