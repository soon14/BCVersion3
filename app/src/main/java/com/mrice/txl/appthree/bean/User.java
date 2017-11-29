package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;

/**
 * Created by cai on 2017/8/5.
 */

public class User implements Serializable {
    @ParamNames("phone")
    private String phone;
    @ParamNames("password")
    private String password;

    public void setData(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
