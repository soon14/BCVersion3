package com.mrice.txl.appthree.ui.service;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mrice.txl.appthree.MainActivity;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.databinding.FragmentServiceBinding;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.mrice.txl.appthree.utils.ToastUtil;

/**
 * Created by company on 2017/8/2.
 */

public class ServiceFragment extends BaseFragment<FragmentServiceBinding> implements View.OnClickListener {
    private MainActivity activity;

    @Override
    public int setContent() {
        return R.layout.fragment_service;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        initWebView();

        webView.loadUrl("file:///android_asset/zhejiang.html");
        bindingView.daxiao.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                webView.loadUrl("file:///android_asset/henan.html");
            }
        });
        bindingView.jiou.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                webView.loadUrl("file:///android_asset/cai.html");
            }
        });
        bindingView.zhixuan.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                webView.loadUrl("file:///android_asset/zhejiang.html");
            }
        });
    }

    private WebView webView;

    private void initWebView() {
        webView = bindingView.webviewDetail;
        WebSettings ws = webView.getSettings();
        // 网页内容的宽度是否可大于WebView控件的宽度
        ws.setLoadWithOverviewMode(false);
        // 保存表单数据
        ws.setSaveFormData(true);
        // 是否应该支持使用其屏幕缩放控件和手势缩放
        ws.setSupportZoom(true);
        ws.setBuiltInZoomControls(true);
        ws.setDisplayZoomControls(false);
        // 启动应用缓存
        ws.setAppCacheEnabled(true);
        // 设置缓存模式
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);
        // setDefaultZoom  api19被弃用
        // 设置此属性，可任意比例缩放。
        ws.setUseWideViewPort(true);
        // 缩放比例 1
        webView.setInitialScale(1);
        // 告诉WebView启用JavaScript执行。默认的是false。
        ws.setJavaScriptEnabled(true);
        //  页面加载好以后，再放开图片
        ws.setBlockNetworkImage(false);
        // 使用localStorage则必须打开
        ws.setDomStorageEnabled(true);
        // 排版适应屏幕
        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        // WebView是否支持多个窗口。
        ws.setSupportMultipleWindows(true);

        // webview从5.0开始默认不允许混合模式,https中不能加载http资源,需要设置开启。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ws.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        /** 设置字体默认缩放大小(改变网页字体大小,setTextSize  api14被弃用)*/
        ws.setTextZoom(100);

        webView.setWebChromeClient(new WebChromeClient());
        // 与js交互
        webView.setWebViewClient(new WebViewClient() {


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                ToastUtil.showToast("请检查网络是否良好");
                showError();
            }
        });
    }

    @Override
    protected void onRefresh() {
        super.onRefresh();
        showContentView();
        initWebView();
        webView.loadUrl("file:///android_asset/zhejiang.html");

    }
}
