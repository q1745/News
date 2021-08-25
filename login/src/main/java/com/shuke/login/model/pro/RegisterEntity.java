package com.shuke.login.model.pro;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.shuke.login.BR;

/**
 * @CreateDate: 2021/8/24 9:36
 * @name:haonan
 * @Contact information:qq by 1612258670
 * @ProjectName: News
 * @Package: com.shuke.login.model.pro
 * @ClassName: RegisterEntity
 */
public class RegisterEntity {
    public Integer id;
    public String username;
    public String pwd;
    public String sex;
    public String birthday;

    public RegisterEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public RegisterEntity(Integer id, String username, String pwd, String sex, String birthday) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.sex = sex;
        this.birthday = birthday;
    }
}
