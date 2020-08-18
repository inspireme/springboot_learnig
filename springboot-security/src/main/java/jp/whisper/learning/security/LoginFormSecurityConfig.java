package jp.whisper.learning.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;

/**
 * @ClassName SecurityConfig
 * @Description single securityconfig
 * @Author whisper
 * @Date 2020/05/04 15:06
 * @Version 1.0
 */
//@Configuration
public class LoginFormSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("user1").password("pwd1").roles("admin");
//                .and().withUser("user2").password("pwd2");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login.action")
//                .usernameParameter("username").passwordParameter("passwd")
//                .defaultSuccessUrl("/index.html")
//                .failureUrl("/error.html")
//                .and().logout().logoutUrl("/logout")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.toString()))
//                .logoutSuccessUrl("/login.html")
//                .deleteCookies().clearAuthentication(true).invalidateHttpSession(true)
//                .permitAll().and().csrf().disable();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login.action")
                .usernameParameter("username").passwordParameter("passwd")
                .successHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("login success");
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, exception)->{
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("login failure");
                    out.flush();
                    out.close();
                })
                .permitAll().and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", HttpMethod.GET.toString()))
                .logoutSuccessUrl("/login.html")
                .logoutSuccessHandler((req, resp, authentication) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("logout success");
                    out.flush();
                    out.close();
                })
                .deleteCookies().clearAuthentication(true).invalidateHttpSession(true)
                .permitAll().and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((req, resp, exception)->{
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write("not login");
                    out.flush();
                    out.close();;
                });
    }
}
