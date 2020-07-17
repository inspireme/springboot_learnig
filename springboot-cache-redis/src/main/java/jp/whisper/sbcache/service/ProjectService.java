package jp.whisper.sbcache.service;

import jp.whisper.sbcache.bean.Project;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectService
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/16 16:51
 * @Version 1.0
 */
@Service
public class ProjectService {

    @Cacheable(cacheNames = "cache1")
    public Project getProjectById(Integer id){
        System.out.println("getProjectById begin>>>>>" + id);
        Project prj = new Project();
        prj.setId(id);
        prj.setName("dummy_project");
        prj.setRemark("remark!!");

        return prj;
    }

    @CacheEvict(cacheNames = "cache1")
    public void deleteProjectById(Integer id){
        System.out.println("deleteProjectById begin>>>>" + id);
    }

    @CachePut(cacheNames = "cache1", key = "#project.id")
    public Project updateProject(Project project){
        project.setRemark("updated!!");

        return project;
    }

}
