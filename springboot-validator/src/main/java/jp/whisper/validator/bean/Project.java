package jp.whisper.validator.bean;


import jp.whisper.validator.validation.CustomSize;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @NotNull(message = "{validation.id.NotNull.message}")
    private Integer id;

    @Length(max = 64) // 最大64
    @NotBlank // 空の文字列は不可
    private String uid;

    @NotNull // nullは不可
    private String contactType;

    @Length(max = 1600) // 最長1600
    private String contact;

    @CustomSize(max = 10)
    private String remark;

    @CustomSize(max = 5, message = "{jp.whisper.validator.validation.CustomSize.message2}")
    private String remark2;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public static ProjectBuilder builder (){
        return new ProjectBuilder();
    }

    // 相関チェックを行うメソッド
    @AssertTrue(message = "{validation.remark2.remark.message}")
    public boolean isMessageNotEmptyIfToPresents() {

        if (StringUtils.isEmpty(remark2)) {
            return true;
        }

        return !StringUtils.isEmpty(remark);
    }
}
