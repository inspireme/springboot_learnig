package jp.whisper.test.controller;

import jp.whisper.test.bean.Project;
import jp.whisper.test.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloRestController
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/14 18:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/project")
public class HelloRestController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/get/{id}")
    public Project get(@PathVariable("id") Integer id){
        Project project = projectService.get(id);

        return project;
    }

    @PostMapping("/update")
    public Project update(@RequestBody Project project){
        return projectService.updateData(project);
    }

}
