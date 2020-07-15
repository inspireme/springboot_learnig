package jp.whisper.validator.controller;

import jp.whisper.validator.bean.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/14 14:30
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class HelloController {

    /**
     * 結果受け取り、validation
     */
    @RequestMapping(path = "form", method = RequestMethod.POST)
    public ModelAndView formPost(ModelAndView mav, @ModelAttribute("project") @Valid Project form,
                                 BindingResult result) {
        // validationのチェック
        if (result.hasFieldErrors()) {
            mav.addObject("errors", result.getFieldErrors());
            mav.addObject("form", form);
            mav.setViewName("demoForm");
            return mav;
        }

        mav.setViewName("ok");
        return mav;
    }

    /**
     * 結果受け取り、validation
     * BindingResultを使わず
     */
    @RequestMapping(path = "form2", method = RequestMethod.POST)
    public ModelAndView formPost2(ModelAndView mav, @ModelAttribute("project") @Valid Project form) {
        mav.setViewName("ok");

        return mav;
    }

    @Autowired
    MessageSource messageSource;
    @GetMapping("/hello")
    public String hello() {
        System.out.println(LocaleContextHolder.getLocale());
        System.out.println(messageSource.getMessage("jp.whisper.validator.validation.CustomSize.message3", new Object[]{"11"}, LocaleContextHolder.getLocale()));
        return null;
    }

}
