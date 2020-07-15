package jp.whisper.sbcontrolleradvice.config;

import jp.whisper.sbcontrolleradvice.exception.BusiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ExceptionConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/22 22:11
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BusiException.class)
    public void myException(BusiException busiException, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(String.format("予想らぬエラーが発生しました!(%s)", busiException.getMessage()));
        out.flush();
        out.close();
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception exception){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("myerror", String.format("予想らねエラーが発生しました!!!!（%s）", exception.getMessage()));

        return mv;
    }

}
