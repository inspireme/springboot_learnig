package jp.whisper.validator.controller;

import jp.whisper.validator.bean.Project;
import jp.whisper.validator.validation.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/15 14:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectValidator projectValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(projectValidator);
    }

    @PostMapping("/check")
    public Project check(@Validated @RequestBody Project project){
        return project;
    }
}
