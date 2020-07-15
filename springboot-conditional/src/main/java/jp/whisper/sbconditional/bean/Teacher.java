package jp.whisper.sbconditional.bean;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 14:15
 * @Version 1.0
 */
public class Teacher implements Person {
    public final static String TYPE = "teacher";

    @Override
    public String getType() {
        return TYPE;
    }
}
