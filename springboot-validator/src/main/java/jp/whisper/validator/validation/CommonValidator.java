package jp.whisper.validator.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @ClassName CommonValidator
 * @Description controller,serviceなどで手動でバリエーションする
 * @Author whisper
 * @Date 2020/07/14 19:13
 * @Version 1.0
 */
public class CommonValidator<T> {

    protected static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Set<ConstraintViolation<T>> validate(T t){
        Set<ConstraintViolation<T>> validateResult = validator.validate(t);
        return validateResult;
    }
}
