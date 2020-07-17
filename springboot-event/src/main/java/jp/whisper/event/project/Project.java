package jp.whisper.event.project;

/**
 * @ClassName Project
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/17 15:13
 * @Version 1.0
 */
public class Project {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
}
