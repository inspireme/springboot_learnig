package jp.whisper.distributedlock.service;

import net.javacrumbs.shedlock.core.LockConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;

/**
 * @ClassName ProjectService
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 16:48
 * @Version 1.0
 */
@Service
public class ProjectService {

    @Autowired
    private ShedLockExecutor shedLockExecutor;

    public String saveProject(String name, Integer id) throws Exception {
        return (String) shedLockExecutor.executeWithLock(
                (t) -> {
                    Arrays.stream(((Object[]) t)).forEach(obj -> {
                        System.out.println(obj);
                    });

                    return "execute success";
                },
                new Object[]{id, name}, new LockConfiguration("key", Duration.ofSeconds(30L), Duration.ofSeconds(5L))
        );
    }

    public String saveProject2(String name, Integer id) throws Exception {
        return (String) shedLockExecutor.executeWithLock2(
                () -> {
                    System.out.println("execute success");
                    return "1111";
                }, new LockConfiguration("key", Duration.ofSeconds(30L), Duration.ofSeconds(5L))
        );
    }
}
