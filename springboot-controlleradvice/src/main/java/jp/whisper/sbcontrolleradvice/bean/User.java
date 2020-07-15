package jp.whisper.sbcontrolleradvice.bean;

/**
 * @ClassName User
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/24 21:56
 * @Version 1.0
 */
public class User {
    private String userId;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
