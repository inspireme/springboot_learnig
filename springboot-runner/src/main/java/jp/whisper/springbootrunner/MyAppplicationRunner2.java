package jp.whisper.springbootrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MyAppplicationRunner
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/26 22:56
 * @Version 1.0
 */
@Component
@Order(100)
public class MyAppplicationRunner2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(this.getClass().toString() + ">>>>>>>>>>> start");

        String[] sourceArgs = args.getSourceArgs();
        System.out.println("sourceArgs >> " + Arrays.toString(sourceArgs));

        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs >>> " + nonOptionArgs.toString());

        Set<String> optionNames = args.getOptionNames();

        for (String optionName : optionNames) {
            System.out.println(optionName + ":" + args.getOptionValues(optionName));
        }

        System.out.println(this.getClass().toString() + ">>>>>>>>>>> end");
    }
}
