package jp.whisper.validator.config;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/15 13:56
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BindException.class)
    public String methodArgumentNotValid(HttpServletRequest req, BindException  ex)  {
        List<ObjectError> errors = ex.getAllErrors();
        StringBuffer errorMsg=new StringBuffer();
        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        return errorMsg.toString();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String methodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException  ex)  {
        System.out.println(ex.getMessage());
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        StringBuffer errorMsg=new StringBuffer();
        errors.stream().forEach(x -> errorMsg.append(x.getCode()).append(";"));
        System.out.println(errorMsg.toString());
        return errorMsg.toString();
    }
}
