package jp.whisper.sbcache.bean;

import java.io.Serializable;

/**
 * @ClassName Project
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/16 16:49
 * @Version 1.0
 */
public class Project implements Serializable {
    private Integer id;
    private String name;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
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
