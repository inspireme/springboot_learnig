package jp.whisper.validator.bean;

/**
 * @ClassName ProjectBuilder
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/14 19:06
 * @Version 1.0
 */
public class ProjectBuilder {

    private Project project;

    ProjectBuilder(){
        this.project = new Project();
    }

    public ProjectBuilder id(Integer id){
        this.project.setId(id);

        return this;
    }

    public ProjectBuilder name (String name){
        this.project.setName(name);

        return this;
    }
    public ProjectBuilder contact (String contact){
        this.project.setContact(contact);

        return this;
    }
    public ProjectBuilder contactType (String contactType){
        this.project.setContactType(contactType);

        return this;
    }
    public ProjectBuilder uid (String uid){
        this.project.setUid(uid);

        return this;
    }

    public ProjectBuilder remark(String remark){
        this.project.setRemark(remark);

        return this;
    }

    public ProjectBuilder remark2(String remark2){
        this.project.setRemark2(remark2);
        return this;
    }

    public Project build(){
        return this.project;
    }
}
