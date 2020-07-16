package jp.whisper.distributedlock.task;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName DummyTask
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/16 17:10
 * @Version 1.0
 */
@Component
public class DummyTask {

    @Value("${server.port}")
    String port;

    Logger logger = (Logger) LoggerFactory.getLogger(DummyTask.class);

    //为了方便测试 设置cron表达式
    @Scheduled(cron = "*/5 * * * * ?")
    //lockAtLeastFor：保证在设置的期间类不执行多次任务，单位是毫秒，此处可以根据实际任务运行情况进行设置，
    //简单来说，一个每15分钟执行的任务，若每次任务执行的时间为几分钟，则可以设置lockAtLeastFor大于其最大估计最大执行时间
    //避免一次任务未执行完，下一个定时任务又启动了。
    //任务执行完，会自动释放锁。
    @SchedulerLock(name="simpleTask",lockAtLeastFor = "1000")
    public void getCurrentDate() {
        logger.info("端口({}),Scheduled定时任务执行：{}", port, new Date());
    }
}
