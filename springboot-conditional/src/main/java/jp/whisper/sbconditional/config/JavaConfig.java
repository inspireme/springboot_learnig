package jp.whisper.sbconditional.config;

import jp.whisper.sbconditional.bean.Person;
import jp.whisper.sbconditional.bean.Student;
import jp.whisper.sbconditional.bean.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName JavaConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 14:29
 * @Version 1.0
 */

@Configuration
public class JavaConfig {

    @Bean("person")
    @Conditional(StudentCondition.class)
    Person student(){
        return new Student();
    }

    @Bean("person")
    @Conditional(TeacherCondition.class)
    Person teacher(){
        return new Teacher();
    }

    @Bean("person2")
    @Profile(Student.TYPE)
    Person student2(){
        return new Student();
    }

    @Bean("person2")
    @Profile(Teacher.TYPE)
    Person teacher2(){
        return new Teacher();
    }

}
