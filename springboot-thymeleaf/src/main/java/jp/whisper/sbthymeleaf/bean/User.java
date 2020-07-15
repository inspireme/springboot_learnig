package jp.whisper.sbthymeleaf.bean;

/**
 * @ClassName User
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/20 23:28
 * @Version 1.0
 */
public class User {
    private int index;
    private String userId;
    private String userName;
    private int age;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
