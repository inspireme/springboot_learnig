package jp.whisper.sbfk.bean;

/**
 * @ClassName User
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/17 0:22
 * @Version 1.0
 */
public class User {
    private int index;
    private String userNo;
    private String name;

    public User(int index, String userNo, String name) {
        this.index = index;
        this.userNo = userNo;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
