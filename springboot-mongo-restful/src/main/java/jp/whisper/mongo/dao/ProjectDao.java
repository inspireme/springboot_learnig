package jp.whisper.mongo.dao;

import jp.whisper.mongo.bean.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path="w_projects", collectionResourceRel = "w_prjs", itemResourceRel = "w_prj")
public interface ProjectDao extends MongoRepository<Project, Integer> {

    @RestResource(path="find_by_name", rel="findbyname")
    public List<Project> findProjectByNameLike(@Param("projectName") String name);

}
