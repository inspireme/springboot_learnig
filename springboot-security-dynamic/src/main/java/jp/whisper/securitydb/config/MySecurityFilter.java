package jp.whisper.securitydb.config;

import jp.whisper.securitydb.bean.Menu;
import jp.whisper.securitydb.bean.Role;
import jp.whisper.securitydb.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName SecurityFilter
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/19 20:00
 * @Version 1.0
 */
@Component
public class MySecurityFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menus = menuService.getAllMenus();
        for (Menu menu : menus) {
            if(antPathMatcher.match(menu.getPattern(), requestUrl)){
                // request url に必要なroleを取得する
                List<Role> roles = menu.getRoles();
                List<String> roleStrList = new ArrayList<>();
                roles.forEach(role -> { roleStrList.add("ROLE_" + role.getName());});

                return SecurityConfig.createList(roleStrList.toArray(new String[roleStrList.size()]));
            }
        }
        return SecurityConfig.createList("ROLE_normal");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
