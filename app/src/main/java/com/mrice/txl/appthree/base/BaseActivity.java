package com.mrice.txl.appthree.base;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.databinding.ActivityBaseBinding;
import com.mrice.txl.appthree.utils.DialogFactory;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.mrice.txl.appthree.view.ProgressDialog;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by cai on 16/12/10.
 */
public abstract class BaseActivity<SV extends ViewDataBinding> extends AppCompatActivity implements View.OnClickListener {

    // 布局view
    protected SV bindingView;
    private LinearLayout llProgressBar;
    private View refresh;
    private ActivityBaseBinding mBaseBinding;
    private AnimationDrawable mAnimationDrawable;
    private CompositeSubscription mCompositeSubscription;
    protected String SUCCESS_CODE = "0";

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    //全局加载框
    protected ProgressDialog progressDialog;
    protected BaseActivity context;

    //点击同一 view 最小的时间间隔，如果小于这个数则忽略此次单击。
    private static long intervalTime = 800;
    //最后点击时间
    private long lastClickTime = 0;
    //最后被单击的 View 的ID
    private long lastClickView = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        mBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base, null, false);
        bindingView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);

        // content
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        RelativeLayout mContainer = (RelativeLayout) mBaseBinding.getRoot().findViewById(R.id.container);
        mContainer.addView(bindingView.getRoot());
        getWindow().setContentView(mBaseBinding.getRoot());

        // 设置透明状态栏
//        StatusBarUtil.setColor(this, CommonUtils.getColor(R.color.colorTheme1), 0);
        llProgressBar = getView(R.id.ll_progress_bar);
        refresh = getView(R.id.ll_error_refresh);
        ImageView img = getView(R.id.img_progress);

        // 加载动画
        mAnimationDrawable = (AnimationDrawable) img.getDrawable();
        // 默认进入页面就开启动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }

        setToolBar();
        // 点击加载失败布局
        refresh.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                showLoading();
                onRefresh();
            }
        });
        bindingView.getRoot().setVisibility(View.GONE);
    }

    /**
     * 设置titlebar
     */
    protected void setToolBar() {
//        setSupportActionBar(mBaseBinding.toolBar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            //去除默认Title显示
//            actionBar.setDisplayShowTitleEnabled(false);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.icon_back);
//        }
//        mBaseBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
        mBaseBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void setBackAction(boolean visible) {
        mBaseBinding.ivBack.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    public void setTitle(CharSequence text) {
//        mBaseBinding.toolBar.setTitle(text);
        mBaseBinding.title.setText(text);
    }

    protected void showLoading() {
        if (llProgressBar.getVisibility() != View.VISIBLE) {
            llProgressBar.setVisibility(View.VISIBLE);
        }
        // 开始动画
        if (!mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
        if (refresh.getVisibility() != View.GONE) {
            refresh.setVisibility(View.GONE);
        }
    }

    protected void showContentView() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (refresh.getVisibility() != View.GONE) {
            refresh.setVisibility(View.GONE);
        }
        if (bindingView.getRoot().getVisibility() != View.VISIBLE) {
            bindingView.getRoot().setVisibility(View.VISIBLE);
        }
    }

    protected void showError() {
        if (llProgressBar.getVisibility() != View.GONE) {
            llProgressBar.setVisibility(View.GONE);
        }
        // 停止动画
        if (mAnimationDrawable.isRunning()) {
            mAnimationDrawable.stop();
        }
        if (refresh.getVisibility() != View.VISIBLE) {
            refresh.setVisibility(View.VISIBLE);
        }
        if (bindingView.getRoot().getVisibility() != View.GONE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
    }

    /**
     * 失败后点击刷新
     */
    protected void onRefresh() {

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
        progressDialog = DialogFactory.createProgressDialog(context, msg);

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

    @Override
    public void onClick(View view) {
        if (!isFastMultiClick(view)) {
            onViewClick(view);
        }
    }

    /**
     * 防短时重复点击回调 <br>
     * 子类使用 View.OnClickListener 设置监听事件时直接覆写该方法完成点击回调事件
     *
     * @param view 被单击的View
     */
    protected void onViewClick(View view) {
        //供字类重写用事件
    }

    /**
     * 是否快速多次点击(连续多点击）
     *
     * @param view 被点击view，如果前后是同一个view，则进行双击校验
     * @return 认为是重复点击时返回true。
     */
    private boolean isFastMultiClick(View view) {
        long time = System.currentTimeMillis() - lastClickTime;

        if (time < intervalTime && lastClickView == view.getId()) {
            lastClickTime = System.currentTimeMillis();
            return true;
        }

        lastClickTime = System.currentTimeMillis();
        lastClickView = view.getId();

        return false;
    }

    public RequestBody getRequestBody(String json) {
        return RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), json);
    }
}
