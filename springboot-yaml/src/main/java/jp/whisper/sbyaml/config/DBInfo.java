package jp.whisper.sbyaml.config;

/**
 * @ClassName DBInfo
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/16 22:10
 * @Version 1.0
 */
public class DBInfo {
    private String user;
    private String password;
    private String dbname;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    @Override
    public String toString() {
        return "DBInfo{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", dbname='" + dbname + '\'' +
                '}';
    }
}
