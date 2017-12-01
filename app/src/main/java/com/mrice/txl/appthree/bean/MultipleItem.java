package com.mrice.txl.appthree.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by app on 2017/11/30.
 */
public class MultipleItem implements MultiItemEntity{

    public static final int XINWEN = 1;
    public static final int MUKUAI = 2;
    public static final int BANNER = 3;
    public static final int MUKUAI2 = 4;
    private int itemType;

    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    private String title;
    private String content;
    private String pubTime;
    private String url;
    private String source;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
