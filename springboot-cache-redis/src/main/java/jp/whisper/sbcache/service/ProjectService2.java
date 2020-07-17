package jp.whisper.sbcache.service;

import jp.whisper.sbcache.bean.Project;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProjectServie2
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/16 17:29
 * @Version 1.0
 */
@CacheConfig(cacheNames = "cache2", keyGenerator = "cacheKeyGenerator")
@Service
public class ProjectService2 {

    @Cacheable
    public Project getProjectById(Integer id){
        System.out.println("getProjectById begin>>>>>" + id);
        Project prj = new Project();
        prj.setId(id);
        prj.setName("dummy_project");
        prj.setRemark("remark!!");

        return prj;
    }

    @CacheEvict
    public void deleteProjectById(Integer id){
        System.out.println("deleteProjectById begin>>>>" + id);
    }

    @CachePut
    public Project updateProject(Project project){
        project.setRemark("updated22!!");

        return project;
    }

}
