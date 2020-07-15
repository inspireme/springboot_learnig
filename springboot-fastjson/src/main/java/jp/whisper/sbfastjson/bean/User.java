package jp.whisper.sbfastjson.bean;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/21 16:22
 * @Version 1.0
 */
public class User {
    private String userId;
    private String userName;
    private Date birthday;
    private Integer age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
