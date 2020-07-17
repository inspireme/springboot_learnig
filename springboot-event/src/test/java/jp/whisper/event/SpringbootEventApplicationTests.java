package jp.whisper.event;

import jp.whisper.event.project.Project;
import jp.whisper.event.project.ProjectService;
import jp.whisper.event.project.ProjectService2;
import jp.whisper.event.project.ProjectService3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootEventApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectService2 projectService2;

    @Autowired
    ProjectService3 projectService3;

    @Test
    public void testSaveProject(){
        Project project = new Project();
        project.setId(1);
        project.setName("dummy");

        this.projectService.saveProject(project);

        project.setId(2);
        this.projectService2.saveProject(project);

        project.setId(3);
        this.projectService3.saveProject(project);

        project.setId(4);
        this.projectService3.updateProject(project);

    }

}
