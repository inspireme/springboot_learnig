package jp.whisper.sbproperties.annotation;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName AnnotationProcessor
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/16 10:07
 * @Version 1.0
 */
public class AnnotationProcessor {

    public static void parseMethod(final Class<?> cls) throws Exception {
        final Object o = cls.getConstructor(new Class[]{}).newInstance();
        final Method[] methods = cls.getMethods();

        Arrays.asList(methods).forEach(
                method -> {
                    Optional.ofNullable(method.getAnnotation(MyAnnotation.class)).ifPresent(myAnnotation1 -> {
                        try {
                            method.invoke(o, myAnnotation1.value());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
        );
    }

    public static void parseMethod2(final Class<?> cls) throws Exception {
        final Object o = cls.getConstructor(new Class[]{}).newInstance();
        final Method[] methods = cls.getMethods();

        Arrays.asList(methods).forEach(
                method -> {
                    Optional.ofNullable(AnnotationUtils.findAnnotation(method, MyAnnotation.class)).ifPresent(
                            myAnnotation1 -> {
                                try {
                                    method.invoke(o, myAnnotation1.value());
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                    );
                }
        );
    }


}
