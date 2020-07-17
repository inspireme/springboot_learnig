package jp.whisper.event.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectEventPublisher
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 15:09
 * @Version 1.0
 */
@Service
public class ProjectService3 {
    @Autowired
    private  ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;

    public Project saveProject(Project project){
        this.applicationEventPublisher.publishEvent(new ProjectEvent(project));

        return project;
    }

    public Project updateProject(Project project){
        this.applicationContext.publishEvent(new ProjectEvent(project));

        return project;
    }

}
