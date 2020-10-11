package jp.whisper.actuator.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/09/03 18:55
 * @Version 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatcher(EndpointRequest.toAnyEndpoint())
//                .authorizeRequests()
//                .anyRequest().hasRole("admin")
//                .and()
//                .httpBasic();

        http.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests((registry) ->
                registry.anyRequest().hasRole("admin")).httpBasic();
    }
}
