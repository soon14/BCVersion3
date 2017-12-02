package com.mrice.txl.appthree.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.gson.Gson;
import com.mrice.txl.appthree.HomeActivity;
import com.mrice.txl.appthree.HomeActivity2;
import com.mrice.txl.appthree.MainActivity;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.bean.SwitchBean;
import com.mrice.txl.appthree.bean.SwitchDetails;
import com.mrice.txl.appthree.databinding.ActivityTransitionBinding;
import com.mrice.txl.appthree.http.RetrofitHttpClient;
import com.mrice.txl.appthree.ui.login.LoginActivity;
import com.mrice.txl.appthree.utils.CommonUtils;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.view.webview.WebViewBingo1Activity;

import java.util.Random;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


public class WelcomeActivity extends Activity {
    private CompositeSubscription mCompositeSubscription;
    private ActivityTransitionBinding mBinding;
    private boolean animationEnd;
    private int[] mDrawables = new int[]{R.drawable.welcome2};
    //    private int[] mDrawables = new int[]{R.drawable.b_1, R.drawable.b_2,
//            R.drawable.b_3, R.drawable.b_4, R.drawable.b_5, R.drawable.b_6,
//    };
    private boolean isIn;
    private String link;
    private static Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_transition);

        int i = new Random().nextInt(mDrawables.length);
//        Glide.with(this).load(mDrawables[i]).into(mBinding.ivPic);

        mBinding.ivPic.setImageDrawable(CommonUtils.getDrawable(mDrawables[i]));

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                flags();
//            }
//        }, 500);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition_anim);
        animation.setAnimationListener(animationListener);
        mBinding.ivPic.startAnimation(animation);

    }
//    appname  应用名称
//    appflag:  0 android  1 ios
//    navflag:  对应关系如下（ios此值无效）：1,baidu 2,yyb 3vivo 4 oppo 5 cai


    @Override
    protected void onStart() {
        super.onStart();
    }

    private void flags() {
        /*Subscription subscription = RetrofitHttpClient.Builder.getAoMenServer().switchOnOff()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewAoMenBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        doNextStep();
                    }

                    @Override
                    public void onNext(NewAoMenBean newAoMenBean) {
                        if (newAoMenBean != null) {
                            if (newAoMenBean.isSwitchOn()) {
                                if (!TextUtils.isEmpty(newAoMenBean.getUrl())) {
                                    link = newAoMenBean.getUrl();
                                    WebViewBingo1Activity.loadUrl(WelcomeActivity.this, link, "");
                                    overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
                                    WelcomeActivity.this.finish();
                                } else {
                                    doNextStep();
                                }
                            } else {
                                doNextStep();
                            }
                        } else {
                            doNextStep();
                        }
                    }
                });*/


        Subscription subscription = RetrofitHttpClient.Builder.getSwitchServer().switchCheck()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SwitchBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        doNextStep();
                    }

                    @Override
                    public void onNext(SwitchBean switchBean) {
                        if (switchBean != null) {
                            String result = new String(Base64.decode(switchBean.getData(), Base64.DEFAULT));
                            SwitchDetails details=gson.fromJson(result,SwitchDetails.class);
                            if(details.isSwitchOn()){
                                if (!TextUtils.isEmpty(details.getUrl())) {
                                    link = details.getUrl();
                                    WebViewBingo1Activity.loadUrl(WelcomeActivity.this, link, "");
                                    overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
                                    WelcomeActivity.this.finish();
                                } else {
                                    doNextStep();
                                }
                            } else {
                                doNextStep();
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
            //toLoginActivity();
            toMainActivity();
    }

    private boolean isLogin() {
        return SPUtils.getBoolean(Constants.IS_LOGIN, false);
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

    /**
     * 实现监听跳转效果
     */
    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationEnd(Animation animation) {
            animationEnd();
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };


    private void animationEnd() {
        synchronized (WelcomeActivity.this) {
            if (!animationEnd) {
                animationEnd = true;
                mBinding.ivPic.clearAnimation();
                flags();
            }
        }
    }

    private void toMainActivity() {
        if (isIn) {
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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

}
