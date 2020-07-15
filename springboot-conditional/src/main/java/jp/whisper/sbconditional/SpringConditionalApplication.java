package jp.whisper.sbconditional;

import jp.whisper.sbconditional.bean.Person;
import jp.whisper.sbconditional.bean.Student;
import jp.whisper.sbconditional.bean.Teacher;
import jp.whisper.sbconditional.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @ClassName SpringConditionalApplication
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 14:34
 * @Version 1.0
 */
public class SpringConditionalApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //パターン①　自分作ったconditionを利用する
        ctx.getEnvironment().getSystemProperties().put("person", Student.TYPE);

        //パターン② Profileを利用する
        ctx.getEnvironment().setActiveProfiles(Teacher.TYPE);

        ctx.register(JavaConfig.class);
        ctx.refresh();;

        Person person = (Person) ctx.getBean("person");
        System.out.println(person.getType());

        Person person1 = (Person) ctx.getBean("person2");
        System.out.println(person1.getType());
    }
}
