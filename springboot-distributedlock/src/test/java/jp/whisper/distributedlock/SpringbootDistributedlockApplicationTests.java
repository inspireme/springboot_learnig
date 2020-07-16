package jp.whisper.distributedlock;

import jp.whisper.distributedlock.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDistributedlockApplicationTests {

    @Autowired
    ProjectService projectService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSaveProject() throws Exception {
        this.projectService.saveProject("dummy name1", 22);
    }

    @Test
    public void testSaveProject2() throws Exception {
        this.projectService.saveProject2("dummy name2", 33);
    }

}
