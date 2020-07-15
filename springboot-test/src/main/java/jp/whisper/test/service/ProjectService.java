package jp.whisper.test.service;

import jp.whisper.test.bean.Project;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectService
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/14 14:40
 * @Version 1.0
 */
@Service
public class ProjectService {

    public boolean saveData(Project project){
        return false;
    }

    public Project get(Integer id){
        Project project = new Project();
        project.setName("dummy");
        project.setId(id);

        return project;
    }

    public Project updateData(Project project){
        return project;
    }
}
