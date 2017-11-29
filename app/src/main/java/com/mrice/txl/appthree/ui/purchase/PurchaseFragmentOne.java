package com.mrice.txl.appthree.ui.purchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.RotateAnimation;

import com.mrice.txl.appthree.ChooseBallActivity;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.EmptyAdapter;
import com.mrice.txl.appthree.adapter.EverydayAdapter;
import com.mrice.txl.appthree.adapter.LotteryBingoAdapter;
import com.mrice.txl.appthree.app.MyApplication;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.bean.AndroidBean;
import com.mrice.txl.appthree.bean.BannerImageBean;
import com.mrice.txl.appthree.bean.NiceBean;
import com.mrice.txl.appthree.databinding.FooterItemPurchaseBinding;
import com.mrice.txl.appthree.databinding.FragmentPurchaseOneBinding;
import com.mrice.txl.appthree.databinding.HeaderItemPurchaseBinding;
import com.mrice.txl.appthree.http.RetrofitHttpClient;
import com.mrice.txl.appthree.http.cache.ACache;
import com.mrice.txl.appthree.model.EverydayModel;
import com.mrice.txl.appthree.utils.CommonUtils;
import com.mrice.txl.appthree.utils.DebugUtil;
import com.mrice.txl.appthree.utils.GlideImageLoader;
import com.mrice.txl.appthree.utils.LogUtil;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.utils.TimeUtil;
import com.mrice.txl.appthree.view.webview.WebViewActivity;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
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
public class PurchaseFragmentOne extends BaseFragment<FragmentPurchaseOneBinding> {

    private static final String TAG = "EverydayFragment";
    private ACache maCache;
    private ArrayList<List<AndroidBean>> mLists;
    private ArrayList<List<BannerImageBean>> mList = new ArrayList<>();
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
        return R.layout.fragment_purchase_one;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        showLoading();
        showContentView();
//        bindingView.llLoading.setVisibility(View.VISIBLE);
//        animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        animation.setDuration(3000);//设置动画持续时间
//        animation.setInterpolator(new LinearInterpolator());//不停顿
//        animation.setRepeatCount(10);
//        bindingView.ivLoading.setAnimation(animation);
//        animation.startNow();

        maCache = ACache.get(getContext());
//        mEverydayModel = new EverydayModel();
//        mBannerImages = (ArrayList<String>) maCache.getAsObject(Constants.BANNER_PIC);
        DebugUtil.error("----mBannerImages: " + (mBannerImages == null));
        DebugUtil.error("----mLists: " + (mLists == null));
//        mHeaderBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.header_item_purchase, null, false);

        initLocalSetting();

        mIsPrepared = true;
        /**
         * 因为启动时先走loadData()再走onActivityCreated，
         * 所以此处要额外调用load(),不然最初不会加载内容
         */
        loadData();
    }

    /**                        ToastUtil.showToast(getString(R.string.network_disable));

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

//        if (!mIsVisible || !mIsPrepared) {
//            return;
//        }
//        loadBannerPicture();
//        showRotaLoading(false);
    }

//
//    private void initLocalSetting() {
//        mEverydayModel.setData(getTodayTime().get(0), getTodayTime().get(1), getTodayTime().get(2));
////        DebugUtil.error("" + year + month + day);
//        // 显示日期,去掉第一位的"0"
////        mHeaderBinding.includeEveryday.tvDailyText.setText(getTodayTime().get(2).indexOf("0") == 0 ?
////                getTodayTime().get(2).replace("0", "") : getTodayTime().get(2));
//        mHeaderBinding.includeEveryday.rlDouble.setOnClickListener(new PerfectClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
////                WebViewActivity.loadUrl(v.getContext(), "https://gank.io/xiandu", "加载中...");
////                toLotteryDetailActivity(getString(R.string.double_color));
//                toChooseBall(1);
//            }
//        });
//        mHeaderBinding.includeEveryday.rlDaletou.setOnClickListener(new PerfectClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
////                RxBus.getDefault().post(RxCodeConstants.JUMP_TYPE_TO_ONE, new RxBusBaseMessage());
////                toLotteryDetailActivity(getString(R.string.daletou));
//                toChooseBall(2);
//            }
//        });
//        mHeaderBinding.includeEveryday.rlRank.setOnClickListener(new PerfectClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
////                toLotteryDetailActivity(getString(R.string.rank_five));
//                toChooseBall(5);
//            }
//        });
//        mHeaderBinding.includeEveryday.rlKuaisan.setOnClickListener(new PerfectClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
////                toLotteryDetailActivity("排列三");
//                toChooseBall(3);
//            }
//        });
//        mHeaderBinding.includeEveryday.rlQxc.setOnClickListener(new PerfectClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
////                toLotteryDetailActivity("排列三");
//                toChooseBall(7);
//            }
//        });
//        mHeaderBinding.includeEveryday.rlThreed.setOnClickListener(new PerfectClickListener() {
//            @Override
//            protected void onNoDoubleClick(View v) {
////                toLotteryDetailActivity("排列三");
//                toChooseBall(4);
//            }
//        });
//
////        getBall();
//    }

    private void initLocalSetting() {
//        mEverydayModel.setData(getTodayTime().get(0), getTodayTime().get(1), getTodayTime().get(2));
//        DebugUtil.error("" + year + month + day);
        // 显示日期,去掉第一位的"0"
//        mHeaderBinding.includeEveryday.tvDailyText.setText(getTodayTime().get(2).indexOf("0") == 0 ?
//                getTodayTime().get(2).replace("0", "") : getTodayTime().get(2));
        bindingView.rlDouble.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
//                WebViewActivity.loadUrl(v.getContext(), "https://gank.io/xiandu", "加载中...");
//                toLotteryDetailActivity(getString(R.string.double_color));
                toChooseBall(1);
            }
        });
        bindingView.rlDaletou.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
//                RxBus.getDefault().post(RxCodeConstants.JUMP_TYPE_TO_ONE, new RxBusBaseMessage());
//                toLotteryDetailActivity(getString(R.string.daletou));
                toChooseBall(2);
            }
        });
        bindingView.rlRank.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
//                toLotteryDetailActivity(getString(R.string.rank_five));
                toChooseBall(5);
            }
        });
        bindingView.rlKuaisan.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
//                toLotteryDetailActivity("排列三");
                toChooseBall(4);
            }
        });
        bindingView.rlQxc.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
//                toLotteryDetailActivity("排列三");
                toChooseBall(7);
            }
        });
        bindingView.rlThreed.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
//                toLotteryDetailActivity("排列三");
                toChooseBall(3);
            }
        });

//        getBall();
    }

    private void toChooseBall(int mChooseType) {
        Intent intent = new Intent(getContext(), ChooseBallActivity.class);
        intent.putExtra(Constants.MCHOOSETYPE, mChooseType);
        startActivity(intent);
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
        HashMap map = new HashMap();
        map.put(Constants.PAGE_NUM, 1);
        map.put(Constants.APP_NAME, MyApplication.getInstance().getTodayTime());
        map.put(Constants.TYPE, "0");
        RequestBody requestBody = getRequestBody(new Gson().toJson(map));
        Subscription subscription = RetrofitHttpClient.Builder.getYunServer().getBannerImage(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NiceBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.print(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(NiceBean niceBean) {
                        List<BannerImageBean> bannerImageBeanList = null;
                        if (niceBean != null) {
                            if (niceBean.getPageInfo() != null) {
                                bannerImageBeanList = niceBean.getPageInfo().getList();
                            }
                        }
                        if (mBannerImages == null) {
                            mBannerImages = new ArrayList<String>();
                        } else {
                            mBannerImages.clear();
                        }
                        if (bannerImageBeanList != null && bannerImageBeanList.size() > 0) {
                            final List<BannerImageBean> result = bannerImageBeanList;
                            if (result != null && result.size() > 0) {
                                for (int i = 0; i < result.size(); i++) {
                                    //获取所有图片
                                    mBannerImages.add(result.get(i).getUrl());
                                }
                                mHeaderBinding.banner.setImages(mBannerImages).setImageLoader(new GlideImageLoader()).start();
                                mHeaderBinding.banner.setOnBannerClickListener(new OnBannerClickListener() {
                                    @Override
                                    public void OnBannerClick(int position) {
                                        position = position - 1;
                                        // 链接没有做缓存，如果轮播图使用的缓存则点击图片无效
                                        if (result.get(position) != null && result.get(position).getLink() != null) {
                                            WebViewActivity.loadUrl(getContext(), result.get(position).getLink(), result.get(position).getCreateUser());
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
            animation.startNow();
        } else {
            bindingView.llLoading.setVisibility(View.GONE);
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
