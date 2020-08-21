package jp.whisper.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyUsernamePasswordAuthenticationFilter
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/21 11:40
 * @Version 1.0
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private Map<String, String> requestParameter = new HashMap<>();

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            requestParameter = this.getRequestParameterOfJson(request);
        }

        return super.attemptAuthentication(request, response);
    }

    public Map<String, String> getRequestParameterOfJson(HttpServletRequest request) {
        try {
            requestParameter = new ObjectMapper().readValue(request.getInputStream(), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requestParameter;
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            return this.requestParameter.get(getPasswordParameter());
        }
        return super.obtainPassword(request);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            return this.requestParameter.get(getUsernameParameter());
        }
        return super.obtainUsername(request);
    }
}
