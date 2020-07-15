package jp.whisper.sbproperties.annotation;

import org.springframework.core.annotation.AnnotationUtils;

/**
 * @ClassName MyAnnotationTest
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/16 10:34
 * @Version 1.0
 */
public class MyAnnotationTest {

    @MyAnnotation(value = "11111")
    public void sayHello(String name){
        System.out.println(String.format("hello1, %s!", name));
    }

    @MyAnnotation(name = "22222")
    public void sayHello2(String name){
        System.out.println(String.format("hello2, %s!", name));
    }

    public static void main(String[] args) throws Exception {
        AnnotationProcessor.parseMethod(MyAnnotationTest.class);

        AnnotationProcessor.parseMethod2(MyAnnotationTest.class);

    }
}

