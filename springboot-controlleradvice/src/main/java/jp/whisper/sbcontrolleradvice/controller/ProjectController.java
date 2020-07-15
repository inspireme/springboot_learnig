package jp.whisper.sbcontrolleradvice.controller;

import jp.whisper.sbcontrolleradvice.bean.ProjectInfo;
import jp.whisper.sbcontrolleradvice.bean.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/22 22:49
 * @Version 1.0
 */
@RestController
@RequestMapping("/pro")
public class ProjectController {

    @GetMapping("/project")
    public Map<String, String> project(Model model) {
        Map<String, Object> map = model.asMap();
        Map<String, String> map2 = new HashMap<>();
        map.forEach((key, value) -> {
            Map map3 = (Map) value;
            map3.forEach((key3, value3) -> {
                map2.put(key + "." + key3, (String) value3);
            });
        });

        return map2;
    }

    @PostMapping("/addProject")
    public void addProject(@ModelAttribute("prj") ProjectInfo projectInfo, @ModelAttribute("u") User user){
        System.out.println(projectInfo);
        System.out.println(user);
    }
}
