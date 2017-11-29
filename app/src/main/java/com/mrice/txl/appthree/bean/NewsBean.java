package com.mrice.txl.appthree.bean;


import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cai on 2017/8/29.
 */

public class NewsBean implements Serializable {
    @ParamNames("result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "result=" + result +
                '}';
    }

    public static class Result implements Serializable {
        @ParamNames("start")
        private String start;
        @ParamNames("data")
        private List<NewsData> data;

        @Override
        public String toString() {
            return "Result{" +
                    "start='" + start + '\'' +
                    ", data=" + data +
                    '}';
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public List<NewsData> getData() {
            return data;
        }

        public void setData(List<NewsData> data) {
            this.data = data;
        }

        public static class NewsData implements Serializable {
            @ParamNames("uniquikey")
            private String uniquikey;
            @ParamNames("title")
            private String title;
            @ParamNames("data")
            private String date;
            @ParamNames("author_name")
            private String author_name;
            @ParamNames("url")
            private String url;
            @ParamNames("thumbnail_pic_s")
            private String thumbnail_pic_s;
            @ParamNames("thumbnail_pic_s02")
            private String thumbnail_pic_s02;
            @ParamNames("thumbnail_pic_s03")
            private String thumbnail_pic_s03;

            public String getUniquikey() {
                return uniquikey;
            }

            public void setUniquikey(String uniquikey) {
                this.uniquikey = uniquikey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }

            @Override
            public String toString() {
                return "NewsData{" +
                        "uniquikey='" + uniquikey + '\'' +
                        ", title='" + title + '\'' +
                        ", date='" + date + '\'' +
                        ", author_name='" + author_name + '\'' +
                        ", url='" + url + '\'' +
                        ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                        ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                        ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                        '}';
            }
        }
    }


}
