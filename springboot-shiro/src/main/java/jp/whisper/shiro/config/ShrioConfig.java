package jp.whisper.shiro.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ShrioConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/20 17:57
 * @Version 1.0
 */
@Configuration
public class ShrioConfig {
    @Bean
    Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("user=123,user \n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write \n user=read");
        return realm;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/doLogin", "anon");//anonymous
        definition.addPathDefinition("/**", "authc");
        return definition;
    }
}
