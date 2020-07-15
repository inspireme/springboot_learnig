package jp.whisper.test.bean;


import javax.validation.constraints.NotBlank;

/**
 * @ClassName Project
 * @Description TODO
 * @Author whisper
 * @Date 2020/07/14 14:32
 * @Version 1.0
 */
public class Project {
    @NotBlank(message = "名前は必須項目です。")
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
