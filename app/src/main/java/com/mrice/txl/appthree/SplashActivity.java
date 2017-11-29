package com.mrice.txl.appthree;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.mrice.txl.appthree.app.MyApplication;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.bean.AoMenBean;
import com.mrice.txl.appthree.databinding.ActivitySplashBinding;
import com.mrice.txl.appthree.http.RetrofitHttpClient;
import com.mrice.txl.appthree.ui.login.LoginActivity;
import com.mrice.txl.appthree.utils.DialogFactory;
import com.mrice.txl.appthree.utils.GlideImageLoader;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.utils.ToastUtil;
import com.mrice.txl.appthree.view.ProgressDialog;
import com.mrice.txl.appthree.view.webview.WebViewBingo1Activity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * 引导图，正在完成中
 */
public class SplashActivity extends AppCompatActivity {
    private CompositeSubscription mCompositeSubscription;
    private boolean isIn;
    private String link;
    private ActivitySplashBinding mDataBing;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDataBing = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        if (isSplash()) {
            mDataBing.ivSplash.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    flags();
                }
            }, 1000);
            return;
        }

        final ArrayList<Integer> mDrawables = new ArrayList<>();
        mDrawables.add(R.drawable.splash_xuan);
        mDrawables.add(R.drawable.splash_xuan);
//        mDrawables.add(R.drawable.b_3);
//        mDrawables.add(R.drawable.b_4);
        mDataBing.bannerSplash.setImages(mDrawables).setImageLoader(new GlideImageLoader()).start();

        mDataBing.bannerSplash.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mDataBing.experience.setVisibility(position == mDrawables.size() ? View.VISIBLE : View.GONE);
                mDataBing.experience.setOnClickListener(new PerfectClickListener() {
                    @Override
                    protected void onNoDoubleClick(View v) {
                        mDataBing.experience.setVisibility(View.GONE);
                        mDataBing.bannerSplash.setVisibility(View.INVISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                showProgressDialog();
                                flags();
                            }
                        }, 500);
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void flags() {
        HashMap map = new HashMap();
        map.put("appname", MyApplication.getInstance().getTodayTime());
        map.put(Constants.NAV_FLAG, "1");
        map.put(Constants.APP_FLAG, "0");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Subscription subscription = RetrofitHttpClient.Builder.getAoMenServer().getAoMenPage(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AoMenBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        doNextStep();
                        ToastUtil.showToast(getString(R.string.network_disable));
                    }

                    @Override
                    public void onNext(AoMenBean aoMenBean) {
                        hideProgressDialog();
                        mDataBing.ivSplash.setVisibility(View.GONE);
                        if (TextUtils.equals(aoMenBean.getCode(), "0")) {
                            if (aoMenBean != null) {
                                if (aoMenBean.getAppInfo() != null) {
                                    if (aoMenBean.getAppInfo().getStatus()) {
                                        doNextStep();
                                    } else {
                                        link = aoMenBean.getAppInfo().getJumplink();
                                        WebViewBingo1Activity.loadUrl(SplashActivity.this, link, "");
                                        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
                                        SplashActivity.this.finish();
                                    }

                                }
                            }
                        } else {
                            doNextStep();
                        }
                    }
                });
        addSubscription(subscription);

    }

    /**
     * 点击下一步
     */
    private void doNextStep() {
        if (isLogin())
            toMainActivity();
        else
            toLoginActivity();
    }

    private boolean isLogin() {
        return SPUtils.getBoolean(Constants.IS_LOGIN, false);
    }

    private boolean isSplash() {
        return SPUtils.getBoolean(Constants.IS_SPLASH, false);
    }

    private void toLoginActivity() {
        if (isIn) {
            return;
        }
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
        isIn = true;
    }

    private void toMainActivity() {
        if (isIn) {
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
        finish();
        isIn = true;
    }

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    public void removeSubscription() {
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    protected Dialog showProgressDialog() {
        return showProgressDialog("正在加载中");
    }

    protected Dialog showProgressDialog(int msgId) {
        String msg = getString(msgId);
        return showProgressDialog(msg);
    }

    protected Dialog showProgressDialog(String msg) {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = DialogFactory.createProgressDialog(this, msg);

        if (!progressDialog.isShowing()) {
            progressDialog.setMessage(msg);
            progressDialog.show();
        }
        return progressDialog;
    }

    public void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }

    }

}
