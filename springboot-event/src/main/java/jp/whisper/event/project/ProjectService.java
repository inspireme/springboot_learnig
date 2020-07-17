package jp.whisper.event.project;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectEventPublisher
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 15:09
 * @Version 1.0
 */
@Service
public class ProjectService implements ApplicationContextAware{
    private  ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Project saveProject(Project project){
        this.applicationContext.publishEvent(new ProjectEvent(project));

        return project;
    }

}
