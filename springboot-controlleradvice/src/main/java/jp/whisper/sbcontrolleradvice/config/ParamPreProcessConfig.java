package jp.whisper.sbcontrolleradvice.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @ClassName ParamPreProcessConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/24 22:19
 * @Version 1.0
 */
@ControllerAdvice
public class ParamPreProcessConfig {

    @InitBinder("prj")
    public void initProjectInfo(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("prj.");
    }

    @InitBinder("u")
    public void initU(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("u.");
    }
}

