package com.mrice.txl.appthree.bean;

import android.text.TextUtils;

import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;

/**
 * Created by company on 2017/8/8.
 */

public class AoMenBean implements Serializable {

    /**
     * appInfo : {"id":"10","appname":"测试游戏hhh","version":"1.0","jumplink":"www.baidu.com","updateflag":"1","updatelink":"士大夫大师傅","navflag":"0","navtitle1":"首页","navlink1":"www.baidu.coms","navtitle2":"个人中心","navlink2":"www.baidu.com","appmall":null,"state":"1"}
     * code : 0
     */
    @ParamNames("appInfo")
    private AppInfoBean appInfo;
    @ParamNames("code")
    private String code;

    public AppInfoBean getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfoBean appInfo) {
        this.appInfo = appInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class AppInfoBean {
        /**
         * id : 10
         * appname : 测试游戏hhh
         * version : 1.0
         * jumplink : www.baidu.com
         * updateflag : 1
         * updatelink : 士大夫大师傅
         * navflag : 0
         * navtitle1 : 首页
         * navlink1 : www.baidu.coms
         * navtitle2 : 个人中心
         * navlink2 : www.baidu.com
         * appmall : null
         * state : 1
         */
        @ParamNames("id")
        private String id;
        @ParamNames("appname")
        private String appname;
        @ParamNames("version")
        private String version;
        @ParamNames("jumplink")
        private String jumplink;
        @ParamNames("updateflag")
        private String updateflag;
        @ParamNames("updatelink")
        private String updatelink;
        @ParamNames("navflag")
        private String navflag;
        @ParamNames("navtitle1")
        private String navtitle1;
        @ParamNames("navlink1")
        private String navlink1;
        @ParamNames("navtitle2")
        private String navtitle2;
        @ParamNames("navlink2")
        private String navlink2;
        @ParamNames("appmall")
        private Object appmall;
        @ParamNames("state")
        private String state;

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

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getJumplink() {
            return jumplink;
        }

        public void setJumplink(String jumplink) {
            this.jumplink = jumplink;
        }

        public String getUpdateflag() {
            return updateflag;
        }

        public void setUpdateflag(String updateflag) {
            this.updateflag = updateflag;
        }

        public String getUpdatelink() {
            return updatelink;
        }

        public void setUpdatelink(String updatelink) {
            this.updatelink = updatelink;
        }

        public String getNavflag() {
            return navflag;
        }

        public void setNavflag(String navflag) {
            this.navflag = navflag;
        }

        public String getNavtitle1() {
            return navtitle1;
        }

        public void setNavtitle1(String navtitle1) {
            this.navtitle1 = navtitle1;
        }

        public String getNavlink1() {
            return navlink1;
        }

        public void setNavlink1(String navlink1) {
            this.navlink1 = navlink1;
        }

        public String getNavtitle2() {
            return navtitle2;
        }

        public void setNavtitle2(String navtitle2) {
            this.navtitle2 = navtitle2;
        }

        public String getNavlink2() {
            return navlink2;
        }

        public void setNavlink2(String navlink2) {
            this.navlink2 = navlink2;
        }

        public Object getAppmall() {
            return appmall;
        }

        public void setAppmall(Object appmall) {
            this.appmall = appmall;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public boolean getStatus() {
            return TextUtils.equals(state, "0");
        }

        @Override
        public String toString() {
            return "AppInfoBean{" +
                    "id='" + id + '\'' +
                    ", appname='" + appname + '\'' +
                    ", version='" + version + '\'' +
                    ", jumplink='" + jumplink + '\'' +
                    ", updateflag='" + updateflag + '\'' +
                    ", updatelink='" + updatelink + '\'' +
                    ", navflag='" + navflag + '\'' +
                    ", navtitle1='" + navtitle1 + '\'' +
                    ", navlink1='" + navlink1 + '\'' +
                    ", navtitle2='" + navtitle2 + '\'' +
                    ", navlink2='" + navlink2 + '\'' +
                    ", appmall=" + appmall +
                    ", state='" + state + '\'' +
                    '}';
        }
    }
}
