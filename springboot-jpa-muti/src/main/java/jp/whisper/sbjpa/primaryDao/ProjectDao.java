package jp.whisper.sbjpa.primaryDao;

import jp.whisper.sbjpa.bean.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ProjectDao
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/04 22:43
 * @Version 1.0
 */
public interface ProjectDao extends JpaRepository<Project, Integer> {

    public Project findProjectById(Integer id);

    @Query(value = "select * from t_project where id = (select max(id) from t_project )", nativeQuery = true)
    public Project getMaxIdProject();

    @Query(value = "insert into t_project(name, manager) values (:#{#project.name}, :#{#project.manager})", nativeQuery = true)
    @Modifying
    @Transactional
    public Integer addProject(@Param("project") Project project) ;

    @Query(value = "insert into t_project(name, manager) values (:name, :manager)", nativeQuery = true)
    @Modifying
    @Transactional
    public Integer addProject2(@Param("name") String name, @Param("manager") String manager) ;

}
