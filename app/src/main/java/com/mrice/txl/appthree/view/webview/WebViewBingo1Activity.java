package com.mrice.txl.appthree.view.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.utils.DialogFactory;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.view.ProgressDialog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;



/**
 * 网页可以处理:
 * 点击相应控件:拨打电话、发送短信、发送邮件、上传图片、播放视频
 * 进度条、返回网页上一层、显示网页标题
 * Thanks to: https://github.com/youlookwhat/WebViewStudy
 * contact me: http://www.jianshu.com/users/e43c6e979831/latest_articles
 */
public class WebViewBingo1Activity extends AppCompatActivity {

    //    WebView webView;
    private WebView tbsContent;
    public static final String url = "http://www.22114600.com";
    // title
    private String mTitle;
    // 网页链接
    private String mUrl;
    // 网页是否加载完成
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_bingo);

        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getIntentData();
        initView();
//        initAndroidWebView();

    }


    private void getIntentData() {
        if (getIntent() != null) {
            mTitle = getIntent().getStringExtra("mTitle");
            mUrl = getIntent().getStringExtra("mUrl");
        }
    }

    private void initView() {
        SPUtils.putBoolean(Constants.IS_SPLASH, true);
        tbsContent = (WebView) findViewById(R.id.webview_detail);
        WebSettings webSetting = tbsContent.getSettings();


        webSetting.setLoadWithOverviewMode(false);
        // 保存表单数据
        webSetting.setSaveFormData(true);
        // 是否应该支持使用其屏幕缩放控件和手势缩放
        webSetting.setDisplayZoomControls(false);
//        // 启动应用缓存
        webSetting.setAppCacheEnabled(true);
        // 设置缓存模式
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        // setDefaultZoom  api19被弃用
        // 设置此属性，可任意比例缩放。
//        webSetting.setUseWideViewPort(true);
        // 缩放比例 1
//        webView.setInitialScale(1);
////        // 告诉WebView启用JavaScript执行。默认的是false。
//        //  页面加载好以后，再放开图片
        webSetting.setBlockNetworkImage(false);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setAppCachePath(this.getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(this.getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0)
                .getPath());
        webSetting.setMixedContentMode(WebSettings.LOAD_NORMAL);
//         webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON);
        tbsContent.setWebChromeClient(new WebChromeClient());
        tbsContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                sslErrorHandler.proceed();
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                showProgressDialog("正在加载中");
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                hideProgressDialog();
            }
        });

        tbsContent.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,
                                        long contentLength) {
                if(url.contains(".apk")||url.contains("apk")||url.contains("down.0234.com")){
                    Uri uri= Uri.parse(url);
                    Intent i=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
            }
        });
        tbsContent.loadUrl(mUrl);

    }


    /**
     * 打开网页:
     *
     * @param mContext 上下文
     * @param mUrl     要加载的网页url
     * @param mTitle   title
     */
    public static void loadUrl(Context mContext, String mUrl, String mTitle) {
        Intent intent = new Intent(mContext, WebViewBingo1Activity.class);
        intent.putExtra("mUrl", mUrl);
        intent.putExtra("mTitle", mTitle);
        mContext.startActivity(intent);
    }

    private void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (tbsContent.canGoBack()) {
                tbsContent.goBack();
                return true;
                //退出网页
            } else {
                moveTaskToBack(false);
                return true;
            }
        }
        return false;
    }

    private void showProgressDialog(String msg) {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = DialogFactory.createProgressDialog(this, msg);
        if (!progressDialog.isShowing()) {
            progressDialog.setMessage(msg);
            progressDialog.show();
        }
    }

    private void initAndroidWebView() {
        //        webView = (WebView) findViewById(R.id.webview_detail);

        //        mProgressBar = (ProgressBar) findViewById(R.id.pb_progress);
        //        WebSettings ws = webView.getSettings();
//        // 网页内容的宽度是否可大于WebView控件的宽度
//        ws.setLoadWithOverviewMode(false);
//        // 保存表单数据
//        ws.setSaveFormData(true);
//        // 是否应该支持使用其屏幕缩放控件和手势缩放
//        ws.setSupportZoom(true);
//        ws.setBuiltInZoomControls(true);
//        ws.setDisplayZoomControls(false);
////        // 启动应用缓存
//        ws.setAppCacheEnabled(true);
//        // 设置缓存模式
//        ws.setCacheMode(WebSettings.LOAD_DEFAULT);
//        ws.setJavaScriptCanOpenWindowsAutomatically(true);
//        // setDefaultZoom  api19被弃用
//        // 设置此属性，可任意比例缩放。
////        ws.setUseWideViewPort(true);
//        // 缩放比例 1
////        webView.setInitialScale(1);
//////        // 告诉WebView启用JavaScript执行。默认的是false。
//        ws.setJavaScriptEnabled(true);
//        ws.setAllowFileAccess(true);
////        //  页面加载好以后，再放开图片
//        ws.setBlockNetworkImage(false);
////         使用localStorage则必须打开
//        ws.setDomStorageEnabled(true);
////         排版适应屏幕
//        ws.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        // WebView是否、支持多个窗口。
//        ws.setSupportMultipleWindows(false);
//
//        // webview从5.0开始默认不允许混合模式,https中不能加载http资源,需要设置开启。
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ws.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        }
//        /** 设置字体默认缩放大小(改变网页字体大小,setTextSize  api14被弃用)*/
////        ws.setTextZoom(100);
//
//        webView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//
//            }
//        });
//        // 与js交互
//        webView.addJavascriptInterface(new ImageClickInterface(this), "injectedObject");
//        webView.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                super.onReceivedError(view, errorCode, description, failingUrl);
//            }
//
//            @Override
//            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                super.onReceivedError(view, request, error);
//            }
//
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
//                super.onReceivedHttpError(view, request, errorResponse);
//
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                webView.loadUrl(mUrl);
//                return true;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                hideProgressDialog();
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//                showProgressDialog("正在加载中");
//            }
//        });
//        webView.loadUrl(mUrl);
    }

//    @Override
//    public void addImageClickListener() {
//        // 这段js函数的功能就是，遍历所有的img节点，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
//        // 如要点击一张图片在弹出的页面查看所有的图片集合,则获取的值应该是个图片数组
//        webView.loadUrl("javascript:(function(){" +
//                "var objs = document.getElementsByTagName(\"img\");" +
//                "for(var i=0;i<objs.length;i++)" +
//                "{" +
//                //  "objs[i].onclick=function(){alert(this.getAttribute(\"has_link\"));}" +
//                "objs[i].onclick=function(){window.injectedObject.imageClick(this.getAttribute(\"src\"),this.getAttribute(\"has_link\"));}" +
//                "}" +
//                "})()");
//
//        // 遍历所有的a节点,将节点里的属性传递过去(属性自定义,用于页面跳转)
//        webView.loadUrl("javascript:(function(){" +
//                "var objs =document.getElementsByTagName(\"a\");" +
//                "for(var i=0;i<objs.length;i++)" +
//                "{" +
//                "objs[i].onclick=function(){" +
//                "window.injectedObject.textClick(this.getAttribute(\"type\"),this.getAttribute(\"item_pk\"));}" +
//                "}" +
//                "})()");
//    }

}
