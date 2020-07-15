package jp.whisper.sbcontrolleradvice.bean;

/**
 * @ClassName ProjectInfo
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/24 21:56
 * @Version 1.0
 */
public class ProjectInfo {
    private String projectId;
    private String name;

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
