package jp.whisper.sbcontrolleradvice.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalDataConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/22 22:41
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalDataConfig {

    @ModelAttribute(value="globalProjectInfo")
    public Map<String, String>  globalData(){
        Map<String, String> map = new HashMap<>();
        map.put("appName", "springboot-controlleradvice");
        map.put("authorName", "whisper");

        return map;
    }
}
