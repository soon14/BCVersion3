package com.mrice.txl.appthree.app;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by cai on 2016/11/22.
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;

    public static MyApplication getInstance() {
        if (myApplication == null) {
            synchronized (MyApplication.class) {
                if (myApplication == null) {
                    myApplication = new MyApplication();
                }
            }
        }
        return myApplication;

    }

    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPusht
    }

    public String getTodayTime() {
        return "彩博士" + 20170926;
    }
}
