package jp.whisper.sbjdbctemplate.bean;

/**
 * @ClassName Usser
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/03 11:49
 * @Version 1.0
 */
public class User {
    private Integer id;
    private String name;
    private String department;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
