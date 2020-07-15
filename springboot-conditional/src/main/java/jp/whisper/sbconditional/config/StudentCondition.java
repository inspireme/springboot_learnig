package jp.whisper.sbconditional.config;

import jp.whisper.sbconditional.bean.Student;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName StudentCondition
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 14:16
 * @Version 1.0
 */
public class StudentCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        return conditionContext.getEnvironment().getProperty("person").matches(Student.TYPE);
    }
}
