package jp.whisper.validator.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = CustomSizeValidator.class)
@Documented
public @interface CustomSize {
    String message() default "{jp.whisper.validator.validation.CustomSize.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int max();

    @Target({FIELD})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        CustomSize[] value();
    }
}

