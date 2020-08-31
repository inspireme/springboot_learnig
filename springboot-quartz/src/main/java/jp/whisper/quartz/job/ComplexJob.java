package jp.whisper.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @ClassName ComplexJob
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/31 18:02
 * @Version 1.0
 */
public class ComplexJob extends QuartzJobBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("complex job >>>" + this.name + " at " + new Date());
    }
}
