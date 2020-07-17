package jp.whisper.sbcache.service;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName CacheKeyGenerator
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/16 23:06
 * @Version 1.0
 */
@Component
public class CacheKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return method.getName() + ":" + Arrays.toString(objects);//user method name and parameters
    }
}
