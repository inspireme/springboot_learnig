package jp.whisper.sbcors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/25 23:01
 * @Version 1.0
 */
@RestController
//@CrossOrigin("http://localhost:8081")
public class ProjectController {

    @GetMapping("/getProject")
    public String getProjectInfo() {
        int i = 1 / 0;
        return "my project";
    }

    @PostMapping("/createProject")
    public String createProject() {
        return "post project";
    }

}



