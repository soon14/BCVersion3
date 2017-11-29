package com.mrice.txl.appthree.ui.purchase;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.mrice.txl.appthree.ChooseBallActivity;
import com.mrice.txl.appthree.MethodActivity;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.EmptyAdapter;
import com.mrice.txl.appthree.adapter.EverydayAdapter;
import com.mrice.txl.appthree.adapter.LotteryBingoAdapter;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.app.IntentValue;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.bean.AndroidBean;
import com.mrice.txl.appthree.bean.LotteryDetailBean;
import com.mrice.txl.appthree.bean.NewsBean;
import com.mrice.txl.appthree.databinding.FooterItemPurchaseBinding;
import com.mrice.txl.appthree.databinding.FragmentPurchaseBinding;
import com.mrice.txl.appthree.databinding.HeaderItemPurchaseBinding;
import com.mrice.txl.appthree.http.RetrofitHttpClient;
import com.mrice.txl.appthree.http.cache.ACache;
import com.mrice.txl.appthree.model.EverydayModel;
import com.mrice.txl.appthree.ui.LotteryDetailActivity;
import com.mrice.txl.appthree.utils.CommonUtils;
import com.mrice.txl.appthree.utils.DebugUtil;
import com.mrice.txl.appthree.utils.GlideImageLoader;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.utils.TimeUtil;
import com.mrice.txl.appthree.utils.ToastUtil;
import com.mrice.txl.appthree.view.webview.WebViewActivity;
import com.bumptech.glide.Glide;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 每日推荐
 * 更新逻辑：判断是否是第二天(相对于2016-11-26)
 * 是：判断是否是大于12：30
 * *****     |是：刷新当天数据
 * *****     |否：使用缓存：|无：请求前一天数据,直到请求到数据为止
 * **********             |有：使用缓存
 * 否：使用缓存 ： |无：请求今天数据
 * **********    |有：使用缓存
 */
public class PurchaseFragment extends BaseFragment<FragmentPurchaseBinding> {

    private static final String TAG = "EverydayFragment";
    private ACache maCache;
    private ArrayList<List<AndroidBean>> mLists;
    private ArrayList<List<NewsBean.Result.NewsData>> mList = new ArrayList<>();
    private ArrayList<String> mBannerImages;
    private EverydayModel mEverydayModel;
    private HeaderItemPurchaseBinding mHeaderBinding;
    private FooterItemPurchaseBinding mFooterBinding;
    private View mHeaderView;
    private View mFooterView;
    private EverydayAdapter mEverydayAdapter;
    private LotteryBingoAdapter mLotterBingoAdapter;
    private boolean mIsPrepared = false;
    private boolean mIsFirst = true;
    // 是否是上一天的请求
    private boolean isOldDayRequest;
    private RotateAnimation animation;
    // 记录请求的日期
    String year = getTodayTime().get(0);
    String month = getTodayTime().get(1);
    String day = getTodayTime().get(2);

    @Override
    public int setContent() {
        return R.layout.fragment_purchase;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        showLoading();
        showContentView();
        bindingView.llLoading.setVisibility(View.VISIBLE);
        animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);//设置动画持续时间
        animation.setInterpolator(new LinearInterpolator());//不停顿
        animation.setRepeatCount(10);
        bindingView.ivLoading.setAnimation(animation);
        animation.startNow();

        maCache = ACache.get(getContext());
        mEverydayModel = new EverydayModel();
        mBannerImages = (ArrayList<String>) maCache.getAsObject(Constants.BANNER_PIC);
        DebugUtil.error("----mBannerImages: " + (mBannerImages == null));
        DebugUtil.error("----mLists: " + (mLists == null));

        mHeaderBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.header_item_purchase, null, false);
        // 设置本地数据点击事件等
        initLocalSetting();
        initRecyclerView();

        mIsPrepared = true;
        /**
         * 因为启动时先走loadData()再走onActivityCreated，
         * 所以此处要额外调用load(),不然最初不会加载内容
         */
        loadData();
    }

    /**
     * 获取当天日期
     */
    private ArrayList<String> getTodayTime() {
        String data = TimeUtil.getData();
        String[] split = data.split("-");
        String year = split[0];
        String month = split[1];
        String day = split[2];
        ArrayList<String> list = new ArrayList<>();
        list.add(year);
        list.add(month);
        list.add(day);
        return list;
    }

    @Override
    protected void loadData() {
        // 显示时轮播图滚动
        if (mHeaderBinding != null && mHeaderBinding.banner != null) {
            mHeaderBinding.banner.startAutoPlay();
            mHeaderBinding.banner.setDelayTime(4000);
        }

        if (!mIsVisible || !mIsPrepared) {
            return;
        }
        getAoMenData();
    }

    private void getAoMenData() {
        showRotaLoading(mIsFirst);
        if (mIsFirst) {
            loadBannerPicture();
            showContentData();
        } else {
            getACacheData();
        }

    }

    private void initLocalSetting() {
        mEverydayModel.setData(getTodayTime().get(0), getTodayTime().get(1), getTodayTime().get(2));
        mHeaderBinding.includeEveryday.rlOne.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(getContext(), "file:///android_asset/guangdong_trend.html", "广东11选5走势图");
            }
        });
        mHeaderBinding.includeEveryday.rlTwo.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(getContext(), "file:///android_asset/zhejiang_trend.html", "浙江11选5走势图");
            }
        });
        mHeaderBinding.includeEveryday.rlThree.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(getContext(), "file:///android_asset/jiangsu_trend.html", "江苏11选5走势图");
            }
        });
        mHeaderBinding.includeEveryday.rlFour.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(getContext(), "file:///android_asset/beijing_trend.html", "北京11选5走势图");
            }
        });
        mHeaderBinding.includeEveryday.rlFive.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(getContext(), "file:///android_asset/hebei_trend.html", "河北11选5走势图");
            }
        });
        mHeaderBinding.includeEveryday.rlSix.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(getContext(), "file:///android_asset/shanghai_trend.html", "上海11选5走势图");
            }
        });


//        getBall();
    }

    private void toChooseBall(int mChooseType) {
        Intent intent = new Intent(getContext(), ChooseBallActivity.class);
        intent.putExtra(Constants.MCHOOSETYPE, mChooseType);
        startActivity(intent);
    }

    private void toMethod(String method) {
        Intent intent = new Intent(getContext(), MethodActivity.class);
        intent.putExtra(Constants.METHOD, method);
        startActivity(intent);
    }


    List<LotteryDetailBean.PageInfo.LotteryDetailBeanIn> list = new ArrayList<>();
    String[] doubleball = new String[]{"10", "18", "19", "29", "32", "22", "09"};
    String[] daletouball = new String[]{"01", "05", "07", "16", "19", "03", "12"};
    String[] rankBall = new String[]{"4", "3", "3", "4", "2"};
    String[] sanball = new String[]{"5", "6", "6"};


    private void toLotteryDetailActivity(String type) {
        Intent intent = new Intent(getContext(), LotteryDetailActivity.class);
        intent.putExtra(IntentValue.lottery_type, type);
        startActivity(intent);
    }


    /**
     * 取缓存
     */
    private void getACacheData() {
        if (mIsFirst) {
            return;
        }

        if (mBannerImages != null && mBannerImages.size() > 0) {
            mHeaderBinding.banner.setImages(mBannerImages).setImageLoader(new GlideImageLoader()).start();
        } else {
            loadBannerPicture();
        }
        mList = (ArrayList<List<NewsBean.Result.NewsData>>) maCache.getAsObject(Constants.EVERYDAY_CONTENT);
        if (mList != null && mList.size() > 0) {
            setAdapter(mList);
        } else {
            showRotaLoading(true);
            showContentData();
        }

    }

    /**
     * 加载正文内容
     */
    private void showContentData() {
        Subscription subscription = RetrofitHttpClient.Builder.getSportServer().getNews("tiyu", Constants.APP_KEY)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        showError();
                        hideProgressDialog();
                        ToastUtil.showToast(getString(R.string.network_disable));
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        List<NewsBean.Result.NewsData> newsDatas = null;
                        if (newsBean != null) {
                            if (newsBean.getResult() != null) {
                                newsDatas = newsBean.getResult().getData();
                                Collections.reverse(newsDatas);
                            }
                        }
                        if (mList != null) {
                            mList.clear();
                        }
                        for (int i = 0; i < 6; i++) {
                            mList.add(i, newsDatas);
                        }
                        if (mList.size() > 0) {
                            setAdapter(mList);
                        }
                    }
                });
        addSubscription(subscription);
    }

    /**
     * 无数据返回时，暂时去掉
     */
    private void setEmptyAdapter() {
        showRotaLoading(false);

        EmptyAdapter emptyAdapter = new EmptyAdapter();
        ArrayList<String> list = new ArrayList<>();
        list.add(CommonUtils.getString(R.string.string_everyday_empty));
        emptyAdapter.addAll(list);
//        bindingView.xrvEveryday.setAdapter(emptyAdapter);

        // 保存请求的日期
        SPUtils.putString("everyday_data", TimeUtil.getData());

        mIsFirst = false;
    }

    private void initRecyclerView() {
        bindingView.xrvEveryday.setPullRefreshEnabled(false);
        bindingView.xrvEveryday.setLoadingMoreEnabled(false);
        if (mHeaderView == null) {
            mHeaderView = mHeaderBinding.getRoot();
            bindingView.xrvEveryday.addHeaderView(mHeaderView);
        }
//        if (mFooterView == null) {
//            mFooterBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.footer_item_purchase, null, false);
//            mFooterView = mFooterBinding.getRoot();
//            bindingView.xrvEveryday.addFootView(mFooterView, true);
//            bindingView.xrvEveryday.noMoreLoading();
//        }
        bindingView.xrvEveryday.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        // 需加，不然滑动不流畅
        bindingView.xrvEveryday.setNestedScrollingEnabled(false);
        bindingView.xrvEveryday.setHasFixedSize(false);
        bindingView.xrvEveryday.setItemAnimator(new DefaultItemAnimator());
    }


    private void setAdapter(ArrayList<List<NewsBean.Result.NewsData>> lists) {
        showRotaLoading(false);
        if (mLotterBingoAdapter == null) {
            mLotterBingoAdapter = new LotteryBingoAdapter();
        } else {
            mLotterBingoAdapter.clear();
        }
        mLotterBingoAdapter.addAll(lists);
//
        maCache.remove(Constants.EVERYDAY_CONTENT);
        // 缓存三天，这样就可以取到缓存了！
        maCache.put(Constants.EVERYDAY_CONTENT, lists, 259200);
        if (mIsFirst) {
            bindingView.xrvEveryday.setAdapter(mLotterBingoAdapter);
        } else {
            mLotterBingoAdapter.notifyDataSetChanged();
        }
        mIsFirst = false;
    }

    @Override
    protected void onInvisible() {
        // 不可见时轮播图停止滚动
        if (mHeaderBinding != null && mHeaderBinding.banner != null) {
            mHeaderBinding.banner.stopAutoPlay();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // 失去焦点，否则RecyclerView第一个item会回到顶部
        bindingView.xrvEveryday.setFocusable(false);
        DebugUtil.error("-----EverydayFragment----onResume()");
        // 开始图片请求
        Glide.with(getActivity()).resumeRequests();
    }

    @Override
    public void onPause() {
        super.onPause();
        DebugUtil.error("-----EverydayFragment----onPause()");
        // 停止全部图片请求 跟随着Activity
        Glide.with(getActivity()).pauseRequests();

    }

    private void loadBannerPicture() {
        Subscription subscription = RetrofitHttpClient.Builder.getSportServer().getNews("caijing", Constants.APP_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        showError();
                        ToastUtil.showToast(getString(R.string.network_disable));
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        List<NewsBean.Result.NewsData> newsDatas = null;
                        if (newsBean != null) {
                            if (newsBean.getResult() != null) {
                                newsDatas = newsBean.getResult().getData();
                            }
                        }
                        if (mBannerImages == null) {
                            mBannerImages = new ArrayList<String>();
                        } else {
                            mBannerImages.clear();
                        }
                        if (newsDatas != null && newsDatas.size() > 0) {
                            final List<NewsBean.Result.NewsData> result = newsDatas;
                            if (result != null && result.size() > 0) {
                                for (int i = 0; i < 6; i++) {
                                    //获取所有图片
                                    mBannerImages.add(result.get(i).getThumbnail_pic_s());
                                }
                                mHeaderBinding.banner.setImages(mBannerImages).setImageLoader(new GlideImageLoader()).start();
                                mHeaderBinding.banner.setOnBannerClickListener(new OnBannerClickListener() {
                                    @Override
                                    public void OnBannerClick(int position) {
                                        position = position - 1;
                                        // 链接没有做缓存，如果轮播图使用的缓存则点击图片无效
                                        if (result.get(position) != null && result.get(position).getUrl() != null) {
                                            WebViewActivity.loadUrl(getContext(), result.get(position).getUrl(), result.get(position).getTitle());
                                        }
                                    }
                                });
                                maCache.remove(Constants.BANNER_PIC);
                                maCache.put(Constants.BANNER_PIC, mBannerImages, 30000);
                            }
                        }
                    }
                });
        addSubscription(subscription);
    }

    private void showRotaLoading(boolean isLoading) {
        if (isLoading) {
            bindingView.llLoading.setVisibility(View.VISIBLE);
            bindingView.xrvEveryday.setVisibility(View.GONE);
            animation.startNow();
        } else {
            bindingView.llLoading.setVisibility(View.GONE);
            bindingView.xrvEveryday.setVisibility(View.VISIBLE);
            animation.cancel();
        }
    }

    @Override
    protected void onRefresh() {
        showContentView();
        showRotaLoading(true);
        loadData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DebugUtil.error("--EverydayFragment   ----onDestroy");
    }

}
