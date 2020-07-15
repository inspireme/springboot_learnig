package jp.whisper.test.controller;

import jp.whisper.test.bean.Project;
import jp.whisper.test.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    @Autowired
    ProjectService projectService;

    /**
     * index
     */
    @RequestMapping(path = "home", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {

        // messageに値を設定
        mav.addObject("message", "hello world");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 入力画面表示
     */
    @RequestMapping(path = "form", method = RequestMethod.GET)
    public ModelAndView form(ModelAndView mav, Project form) {

        // formのnameに初期値を設定
        form.setName("hoge");
        mav.addObject("form", form);
        mav.setViewName("demoForm");
        return mav;
    }

    /**
     * 結果受け取り、validation
     */
    @RequestMapping(path = "form", method = RequestMethod.POST)
    public ModelAndView formPost(ModelAndView mav, @ModelAttribute("project") @Valid Project form,
                                 BindingResult result) {
        // validationのチェック
        if (result.hasErrors()) {
            mav.addObject("errors", result.getFieldErrors());
            mav.addObject("form", form);
            mav.setViewName("demoForm");
            return mav;
        }

        // formの値を保存
        projectService.saveData(form);

        mav.setViewName("ok");
        return mav;
    }
}
