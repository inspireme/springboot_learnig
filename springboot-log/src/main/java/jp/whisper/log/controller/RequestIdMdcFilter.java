package jp.whisper.log.controller;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName RequestIdMdcFilter
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 10:41
 * @Version 1.0
 */
public class RequestIdMdcFilter extends OncePerRequestFilter {
    public final String REQUEST_ID = "REQUEST_ID";
    public final String HEADER_X_REQUEST_ID = "HEADER_X_REQUEST_ID";

    private String newUuid(){
        return UUID.randomUUID().toString();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //request id in header may come from Gateway, eg. Nginx
        String headerRequestId = httpServletRequest.getHeader(HEADER_X_REQUEST_ID);
        MDC.put(REQUEST_ID, StringUtils.isEmpty(headerRequestId) ? newUuid() : headerRequestId);
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } finally {
            MDC.remove(REQUEST_ID);
        }
    }
}
