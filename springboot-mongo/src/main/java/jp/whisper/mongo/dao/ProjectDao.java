package jp.whisper.mongo.dao;

import jp.whisper.mongo.bean.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectDao extends MongoRepository<Project, Integer> {

    public List<Project> findProjectByNameLike(String name);

}
