package jp.whisper.event.project;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ProjectService2 implements ApplicationEventPublisherAware {
    @Autowired
    private  ApplicationEventPublisher applicationEventPublisher;

    public Project saveProject(Project project){
        this.applicationEventPublisher.publishEvent(new ProjectEvent(project));

        return project;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
