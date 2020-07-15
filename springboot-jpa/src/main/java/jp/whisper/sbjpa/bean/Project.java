package jp.whisper.sbjpa.bean;

import javax.persistence.*;

/**
 * @ClassName Project
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/04 22:32
 * @Version 1.0
 */
@Entity(name = "t_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;
    private String manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
