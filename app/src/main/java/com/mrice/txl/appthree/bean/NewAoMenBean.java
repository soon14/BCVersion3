package com.mrice.txl.appthree.bean;

import android.text.TextUtils;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;

/**
 * Created by company on 2017/8/8.
 */

public class NewAoMenBean implements Serializable {


    @ParamNames("id")
    private String id;
    @ParamNames("appname")
    private String appname;
    @ParamNames("status")
    private String status;
    @ParamNames("updateurl")
    private String updateurl;
    @ParamNames("updateflag")
    private String updateflag;
    @ParamNames("url")
    private String url;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateurl() {
        return updateurl;
    }

    public void setUpdateurl(String updateurl) {
        this.updateurl = updateurl;
    }

    public String getUpdateflag() {
        return updateflag;
    }

    public void setUpdateflag(String updateflag) {
        this.updateflag = updateflag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSwitchOn() {
        return TextUtils.equals(status, "1");
    }
}
