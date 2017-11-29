package com.mrice.txl.appthree.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;

import com.mrice.txl.appthree.app.MyApplication;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cai on 2016/11/22.
 * 获取原生资源
 */
public class CommonUtils {

    /**
     * 随机颜色
     */
    public static int randomColor() {
        Random random = new Random();
        int red = random.nextInt(150) + 50;//50-199
        int green = random.nextInt(150) + 50;//50-199
        int blue = random.nextInt(150) + 50;//50-199
        return Color.rgb(red, green, blue);
    }

    /**
     * 得到年月日的"日"
     */
    private String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("dd");
        return dateFm.format(date);
    }

    /**
     * 获取屏幕px
     *
     * @param context
     * @return 分辨率
     */
    static public int getScreenWidthPixels(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(dm);
        return dm.widthPixels;
    }

//	public static void RunOnUiThread(Runnable r) {
//		MyApplication.getInstance().getMainLooper().post(r);
//	}

    public static Drawable getDrawable(int resid) {
        return getResoure().getDrawable(resid);
    }

    public static int getColor(int resid) {
        return getResoure().getColor(resid);
    }

    public static Resources getResoure() {
        return MyApplication.getInstance().getResources();
    }

    public static String[] getStringArray(int resid) {
        return getResoure().getStringArray(resid);
    }

    public static String getString(int resid) {
        return getResoure().getString(resid);
    }

    public static float getDimens(int resId) {
        return getResoure().getDimension(resId);
    }

    public static void removeSelfFromParent(View child) {

        if (child != null) {

            ViewParent parent = child.getParent();

            if (parent instanceof ViewGroup) {

                ViewGroup group = (ViewGroup) parent;

                group.removeView(child);
            }
        }
    }

    /**
     * 一个或多个汉字 ：^[\u0391-\uFFE5]+$
     * <p>
     * 邮政编码：^[1-9]\d{5}$
     * <p>
     * QQ号码：^[1-9]\d{4,10}$
     * <p>
     * 邮箱：^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\.){1,3}[a-zA-z\-]{1,}$
     * <p>
     * 用户名（字母开头 + 数字/字母/下划线）：^[A-Za-z][A-Za-z1-9_-]+$
     * <p>
     * 手机号码：^1[3|4|5|8][0-9]\d{8}$
     * <p>
     * URL：^((http|https)://)?([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$
     * <p>
     * 18位身份证号：^(\d{6})(18|19|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d|X|x)?$
     *
     * @param username
     * @return
     */
    public static boolean checkUsername(String username) {
        Pattern p = Pattern.compile("^[A-Za-z][A-Za-z1-9_-]+$");
        Matcher m = p.matcher(username);
        return m.matches();
    }

    public static String getRequestParams(String key, String value) {
        HashMap<String, String> map = new HashMap<>();
        map.put(key, value);
        return new Gson().toJson(map);
    }

}
