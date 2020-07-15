package jp.whisper.validator.validation;

import jp.whisper.validator.bean.Project;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @ClassName ProjectValidator
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/15 14:26
 * @Version 1.0
 */
@Component
public class ProjectValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Project.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Project project = (Project) o;
        if (project.getRemark2().length() > 5) {
            errors.rejectValue("remark2", "project.remark2.max", null, "remark2 failure");
        }
    }
}
