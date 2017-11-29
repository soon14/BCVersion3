package com.mrice.txl.appthree.bean;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cai on 2017/8/7.
 */

public class DiscoverBean implements Serializable {


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
        return "DiscoverBean{" +
                "code='" + code + '\'' +
                ", pageInfo=" + pageInfo +
                '}';
    }

    public class PageInfo implements Serializable {
        @ParamNames("pageNum")
        private String pageNum;
        @ParamNames("total")
        private String total;
        @ParamNames("pages")
        private String pages;
        @ParamNames("list")
        private List<DiscoverCaiBean> list;


        public class DiscoverCaiBean implements Serializable {
            @ParamNames("id")
            private String id;
            @ParamNames("title")
            private String title;
            @ParamNames("content")
            private String content;
            @ParamNames("createTime")
            private String createTime;
            @ParamNames("photoImg")
            private String photoImg;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public Long getCreateTime() {
                return Long.parseLong(createTime);
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getPhontoImg() {
                return photoImg;
            }

            public void setPhontoImg(String phontoImg) {
                this.photoImg = phontoImg;
            }

            @Override
            public String toString() {
                return "DiscoverCaiBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", createTime='" + createTime + '\'' +
                        ", photoImg='" + photoImg + '\'' +
                        '}';
            }
        }

        public String getPageNum() {
            return pageNum;
        }

        public void setPageNum(String pageNum) {
            this.pageNum = pageNum;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public List<DiscoverCaiBean> getList() {
            return list;
        }

        public void setList(List<DiscoverCaiBean> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return "PageInfo{" +
                    "pageNum='" + pageNum + '\'' +
                    ", total='" + total + '\'' +
                    ", pages='" + pages + '\'' +
                    ", list=" + list +
                    '}';
        }
    }


}
