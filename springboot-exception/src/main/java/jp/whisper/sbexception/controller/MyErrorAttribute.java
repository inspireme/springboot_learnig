package jp.whisper.sbexception.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @ClassName MyErrorAttribute
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/25 22:12
 * @Version 1.0
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("commonMessage", "common_message");

        return errorAttributes;
    }
}
