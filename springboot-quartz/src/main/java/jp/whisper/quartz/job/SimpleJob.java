package jp.whisper.quartz.job;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName SimpleJob
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/31 17:56
 * @Version 1.0
 */
@Component
public class SimpleJob {
    public void hello(){
        System.out.println("this is the sample job!" + new Date());
    }
}
