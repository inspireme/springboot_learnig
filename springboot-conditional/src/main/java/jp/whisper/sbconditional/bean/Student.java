package jp.whisper.sbconditional.bean;

/**
 * @ClassName Student
 * @Description TODO
 * @Author whisper
 * @Date 2020/06/18 14:13
 * @Version 1.0
 */
public class Student implements Person {

    public final static String TYPE = "student";

    @Override
    public String getType() {
        return TYPE;
    }
}
