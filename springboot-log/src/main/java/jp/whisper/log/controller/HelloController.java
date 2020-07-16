package jp.whisper.log.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 10:25
 * @Version 1.0
 */
@Controller
public class HelloController {
    Logger loggerA = org.slf4j.LoggerFactory.getLogger("com.dummy");
    Logger loggerB = org.slf4j.LoggerFactory.getLogger(getClass().getPackage().getName());

    @GetMapping("/")       // URLのパスの指定
    private String top() { // リクエストを受け付けるメソッド

        loggerA.info("これはrootロガーのみ継承されているためFILE_Aのみに出力されます。");
        loggerB.info("これはjp.whisperロガーを継承しているのでFILE_AとFILE_Bに出力されます。");

        return "/index";
    }
}
