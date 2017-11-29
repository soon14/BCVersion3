package com.mrice.txl.appthree.bean;

import android.text.TextUtils;

import com.mrice.txl.appthree.CommonResponse;
import com.mrice.txl.appthree.http.ParamNames;

import java.io.Serializable;

/**
 * Created by cai on 2017/8/5.
 */

public class LoginResponse implements Serializable, CommonResponse {
    @ParamNames("code")
    private String code;
    @ParamNames("valid")
    private String valid;
    @ParamNames("user")
    private User user;


    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isRequestSuccess() {
        return TextUtils.equals(getCode(), CODE_SUCCESS);
    }

    public boolean isRequestFailed() {
        return TextUtils.equals(getCode(), CODE_FAIL);
    }

    public boolean isRequestSituation(){
        return TextUtils.equals(getCode(),CODE_SITUATION);
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "code='" + code + '\'' +
                ", valid='" + valid + '\'' +
                ", user=" + user +
                '}';
    }

    public class User implements Serializable {
        @ParamNames("id")
        private String id;
        @ParamNames("name")
        private String name;
        @ParamNames("password")
        private String password;
        @ParamNames("age")
        private String age;
        @ParamNames("phone")
        private String phone;
        @ParamNames("flag")
        private String flag;
        @ParamNames("integralSum")
        private String integralSum;
        @ParamNames("integralunused")
        private String integralunused;
        @ParamNames("validatetime")
        private String validatetime;
        @ParamNames("vip")
        private String vip;
        @ParamNames("parentId")
        private String parentId;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getIntegralSum() {
            return integralSum;
        }

        public void setIntegralSum(String integralSum) {
            this.integralSum = integralSum;
        }

        public String getIntegralunused() {
            return integralunused;
        }

        public void setIntegralunused(String integralunused) {
            this.integralunused = integralunused;
        }

        public String getValidatetime() {
            return validatetime;
        }

        public void setValidatetime(String validatetime) {
            this.validatetime = validatetime;
        }

        public String getVip() {
            return vip;
        }

        public void setVip(String vip) {
            this.vip = vip;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", age='" + age + '\'' +
                    ", phone='" + phone + '\'' +
                    ", flag='" + flag + '\'' +
                    ", integralSum='" + integralSum + '\'' +
                    ", integralunused='" + integralunused + '\'' +
                    ", validatetime='" + validatetime + '\'' +
                    ", vip='" + vip + '\'' +
                    ", parentId='" + parentId + '\'' +
                    '}';
        }
    }
}
