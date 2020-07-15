package jp.whisper.validator.config;

import org.apache.tomcat.jni.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/15 21:32
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor inteceptor = new LocaleChangeInterceptor();
        inteceptor.setParamName("lang");

        registry.addInterceptor(inteceptor);
    }

    @Bean
    LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.JAPAN);

        return localeResolver;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public Validator validator(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("MyValidationMessages");

        localValidatorFactoryBean.setValidationMessageSource(messageSource);

        return localValidatorFactoryBean;
    }
}
