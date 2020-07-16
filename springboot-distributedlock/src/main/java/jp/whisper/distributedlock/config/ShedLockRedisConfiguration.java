package jp.whisper.distributedlock.config;

import jp.whisper.distributedlock.service.ShedLockExecutor;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @ClassName ShedLockRedisConfiguration
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 16:16
 * @Version 1.0
 */
@Configuration
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S") //PT为固定格式。开启定时任务锁，默认最大时间为30S
public class ShedLockRedisConfiguration {

    @Value("${spring.profiles.active}")
    String env = "dev";

    @Bean
    public LockProvider lockProvider(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockProvider(redisConnectionFactory, env);
    }

    @Bean
    public ShedLockExecutor shedLockExecutor(LockProvider lockProvider){
        return new ShedLockExecutor(lockProvider);
    }


}
