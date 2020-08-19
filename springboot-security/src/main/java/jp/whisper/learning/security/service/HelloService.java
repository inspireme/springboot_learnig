package jp.whisper.learning.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/18 17:53
 * @Version 1.0
 */
@Service
public class HelloService {

    @PreAuthorize("hasRole('admin')")
    public String admin(){
        return "hello admin!";
    }

    @Secured("ROLE_user") //ROLE_ロール名
    public String user(){
        return "hello user!";
    }

}
