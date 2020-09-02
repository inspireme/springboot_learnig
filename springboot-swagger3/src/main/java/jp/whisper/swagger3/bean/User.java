package jp.whisper.swagger3.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName User
 * @Description TODO
 * @Author whisper
 * @Date 2020/08/31 19:17
 * @Version 1.0
 */
@ApiModel(value = "user-model",description = "user model description")
public class User {
    @ApiModelProperty(value = "ユーザーID")
    private Integer id;
    @ApiModelProperty(value = "ユーザー名")
    private String username;
    @ApiModelProperty(value = "住所")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
