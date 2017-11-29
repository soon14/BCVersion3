package com.mrice.txl.appthree.utils;

import android.widget.Toast;

import com.mrice.txl.appthree.app.MyApplication;

/**
 * Created by cai on 2016/12/14.
 * 单例Toast
 */

public class ToastUtil {

    private static Toast mToast;

    public static void showToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), text, Toast.LENGTH_SHORT);
        }
        mToast.setText(text);
        mToast.show();
    }
}
