package com.mrice.txl.appthree.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.LotteryDetailAdapter;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.bean.LotteryDetailBean;
import com.mrice.txl.appthree.databinding.FragmentLotteryCustomDetailBinding;
import com.mrice.txl.appthree.http.RetrofitHttpClient;
import com.mrice.txl.appthree.utils.CommonUtils;
import com.mrice.txl.appthree.utils.DebugUtil;
import com.google.gson.Gson;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cai on 2017/8/7.
 */

public class LotteryDetailCustomFragment extends BaseFragment<FragmentLotteryCustomDetailBinding> {

    private static final String TYPE = "param";
    private int mType = 1;
    private int mPageNum = 1;
    private int mPageSize = 10;
    private boolean mIsPrepared;
    private boolean mIsFirst = true;
    // 开始请求的角标
    private int mStart = 0;
    // 一次请求的数量
    private int mCount = 18;
    private LotteryDetailActivity activity;
    private LotteryDetailAdapter mLotteryDetailAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public int setContent() {
        return R.layout.fragment_lottery_custom_detail;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LotteryDetailActivity) context;
    }

    public static LotteryDetailCustomFragment newInstance(int param) {
        LotteryDetailCustomFragment fragment = new LotteryDetailCustomFragment();
        Bundle args = new Bundle();
        args.putInt(TYPE, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getInt(TYPE);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showContentView();
        bindingView.srlLotterydetail.setColorSchemeColors(CommonUtils.getColor(R.color.colorTheme));
        bindingView.srlLotterydetail.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                DebugUtil.error("-----onRefresh");
//                listTag= Arrays.asList(BookApiUtils.getApiTag(position));
//                String tag=BookApiUtils.getRandomTAG(listTag);
//                doubanBookPresenter.searchBookByTag(BookReadingFragment.this,tag,false);
                bindingView.srlLotterydetail.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mStart = 0;
                        loadCustomData();
                    }
                }, 1000);

            }
        });

//        mBookAdapter = new BookAdapter(getActivity());

//        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        bindingView.xrvLotterydetail.setLayoutManager(mLayoutManager);

//        bindingView.xrvBook.setAdapter(mBookAdapter);

        scrollRecycleView();

        // 准备就绪
        mIsPrepared = true;
        /**
         * 因为启动时先走loadData()再走onActivityCreated，
         * 所以此处要额外调用load(),不然最初不会加载内容
         */
        loadData();
    }

    @Override
    protected void loadData() {
        DebugUtil.error("-----loadData");
        if (!mIsPrepared || !mIsVisible || !mIsFirst) {
            return;
        }

        bindingView.srlLotterydetail.setRefreshing(true);
        bindingView.srlLotterydetail.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadCustomData();
            }
        }, 500);
        DebugUtil.error("-----setRefreshing");
    }


    private void loadCustomData() {
        HashMap map = new HashMap();
        map.put(Constants.TYPE, mType);
        map.put(Constants.PAGE_NUM, mPageNum);
        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        Subscription get = RetrofitHttpClient.Builder.getYunServer().getCaiList(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LotteryDetailBean>() {
                    @Override
                    public void onCompleted() {
                        showContentView();
                        if (bindingView.srlLotterydetail.isRefreshing()) {
                            bindingView.srlLotterydetail.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        showContentView();
                        if (bindingView.srlLotterydetail.isRefreshing()) {
                            bindingView.srlLotterydetail.setRefreshing(false);
                        }
                        if (mStart == 0) {
                            showError();
                        }
                    }

                    @Override
                    public void onNext(LotteryDetailBean lotteryDetailBean) {
                        LotteryDetailBean.PageInfo pageInfo = new LotteryDetailBean.PageInfo();
                        if (lotteryDetailBean != null) {
                            pageInfo = lotteryDetailBean.getPageInfo();
                        }
                        if (mStart == 0) {
                            if (pageInfo != null && pageInfo != null && pageInfo.getList().size() > 0) {

                                if (mLotteryDetailAdapter == null) {
                                    mLotteryDetailAdapter = new LotteryDetailAdapter(getActivity(), mType);
                                }
                                mLotteryDetailAdapter.setType(mType);
                                mLotteryDetailAdapter.setList(pageInfo.getList());
                                mLotteryDetailAdapter.notifyDataSetChanged();
                                bindingView.xrvLotterydetail.setAdapter(mLotteryDetailAdapter);


//                                //构造器中，第一个参数表示列数或者行数，第二个参数表示滑动方向,瀑布流
//                                bindingView.xrvBook.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//                                bindingView.xrvBook.setAdapter(mLotteryDetailAdapter);
//                                bindingView.xrvBook.setPullRefreshEnabled(false);
//                                bindingView.xrvBook.setLoadingMoreEnabled(true);

                            }
                            mIsFirst = false;
                        } else {
                            mLotteryDetailAdapter.setType(mType);
                            mLotteryDetailAdapter.addAll(pageInfo.getList());
                            mLotteryDetailAdapter.notifyDataSetChanged();
                        }
                        if (mLotteryDetailAdapter != null) {
                            mLotteryDetailAdapter.updateLoadStatus(LotteryDetailAdapter.LOAD_PULL_TO);
                        }
                    }
                });
        addSubscription(get);
    }


    public void scrollRecycleView() {
        bindingView.xrvLotterydetail.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();

                    /**StaggeredGridLayoutManager*/
//                    int[] into = new int[(mLayoutManager).getSpanCount()];
//                    lastVisibleItem = findMax(mLayoutManager.findLastVisibleItemPositions(into));

                    if (mLotteryDetailAdapter == null) {
                        return;
                    }
                    if (mLayoutManager.getItemCount() == 0) {
                        mLotteryDetailAdapter.updateLoadStatus(LotteryDetailAdapter.LOAD_NONE);
                        return;

                    }
                    if (lastVisibleItem + 1 == mLayoutManager.getItemCount()
                            && mLotteryDetailAdapter.getLoadStatus() != LotteryDetailAdapter.LOAD_MORE) {
                        mLotteryDetailAdapter.updateLoadStatus(LotteryDetailAdapter.LOAD_MORE);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mPageNum += 1;
                                mStart += mPageSize;
                                loadCustomData();
                            }
                        }, 1000);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();

                /**StaggeredGridLayoutManager*/
//                int[] into = new int[(mLayoutManager).getSpanCount()];
//                lastVisibleItem = findMax(mLayoutManager.findLastVisibleItemPositions(into));
            }
        });
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    protected void onRefresh() {
        bindingView.srlLotterydetail.setRefreshing(true);
        loadCustomData();
    }

}
