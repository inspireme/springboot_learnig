package jp.whisper.springbootrunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName MyCommonLineRunner
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/26 22:39
 * @Version 1.0
 */
@Component
@Order(99)
public class MyCommonLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().toString() + " >> "  + Arrays.toString(args));
    }
}
