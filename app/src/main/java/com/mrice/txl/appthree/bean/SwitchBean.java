package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;

/**
 * Created by Mr on 2017/11/28.
 */

public class SwitchBean implements Serializable{

    @ParamNames("data")
    private String data;
    @ParamNames("rt_code")
    private String rt_code;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRt_code() {
        return rt_code;
    }

    public void setRt_code(String rt_code) {
        this.rt_code = rt_code;
    }
}
