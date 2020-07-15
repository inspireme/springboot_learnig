package jp.whisper.mongo.bean;

/**
 * @ClassName Project
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/09 15:07
 * @Version 1.0
 */
public class Project {
    private Integer id;
    private String name;
    private String remark;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
