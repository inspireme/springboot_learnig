package jp.whisper.quartz.config;

import jp.whisper.quartz.job.ComplexJob;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * @ClassName QuartzConfig
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/31 17:55
 * @Version 1.0
 */
@Configuration
public class QuartzConfig {

    /**
     * job detail
     */
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("simpleJob");
        bean.setTargetMethod("hello");
        return bean;
    }

    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(ComplexJob.class);
        JobDataMap map = new JobDataMap();
        map.put("name", "whisper");
        bean.setJobDataMap(map);
        return bean;
    }

    /**
     * trigger
     **/
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        bean.setStartTime(new Date());
        bean.setRepeatCount(3);
        bean.setRepeatInterval(2000);
        return bean;
    }

    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        bean.setCronExpression("* * * * * ?");
        return bean;
    }

    /**
     * scheduler
     **/
    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
        return bean;
    }
}
