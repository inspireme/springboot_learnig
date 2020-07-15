package jp.whisper.sbexception.config;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName MyErrorViewResolver
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/25 22:27
 * @Version 1.0
 */
@Component
public class MyErrorViewResolver extends DefaultErrorViewResolver{
    public MyErrorViewResolver(ApplicationContext applicationContext, ResourceProperties resourceProperties) {
        super(applicationContext, resourceProperties);
    }

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = super.resolveErrorView(request, status, model);
        modelAndView.setViewName("common-error");
        modelAndView.addObject("msg", "エラー発生!");

        return modelAndView;
    }
}
