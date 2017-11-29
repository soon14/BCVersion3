package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;

/**
 * Created by cai on 2017/8/19.
 */

public class NiceBean implements Serializable {
    @ParamNames("code")
    private String code;
    @ParamNames("pageInfo")
    private PageInfo pageInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public String toString() {
        return "NiceBean{" +
                "code='" + code + '\'' +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
