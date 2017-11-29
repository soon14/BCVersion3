package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;

/**
 * Created by cai on 2017/8/7.
 */

public class BannerImageBean implements Serializable {


    @ParamNames("id")
    private String id;
    @ParamNames("imgId")
    private String imgId;
    @ParamNames("flag")
    private String flag;
    @ParamNames("sort")
    private String sort;
    @ParamNames("url")
    private String url;
    @ParamNames("createUser")
    private String createUser;
    @ParamNames("createDate")
    private Long createDate;
    @ParamNames("link")
    private String link;

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "BannerImageBean{" +
                "id='" + id + '\'' +
                ", imgId='" + imgId + '\'' +
                ", flag='" + flag + '\'' +
                ", sort='" + sort + '\'' +
                ", url='" + url + '\'' +
                ", createUser='" + createUser + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
