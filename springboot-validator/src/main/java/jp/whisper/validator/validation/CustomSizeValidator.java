package jp.whisper.validator.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName CustomSizeValidator
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/14 20:06
 * @Version 1.0
 */
public class CustomSizeValidator implements ConstraintValidator<CustomSize, String> {
    private int max;

    @Override
    public void initialize(CustomSize customSize) {
        max = customSize.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // CustomSizeUtil はチェックロジックだけを記述したクラス
        // getLength の戻り値は int
        return value == null || value.length() <= max;
    }
}
