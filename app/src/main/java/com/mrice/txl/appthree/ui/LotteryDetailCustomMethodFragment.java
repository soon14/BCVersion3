package com.mrice.txl.appthree.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.databinding.FragmentLotteryCustomDetailTwoBinding;
import com.mrice.txl.appthree.utils.DebugUtil;

/**
 * Created by cai on 2017/8/7.
 */

public class LotteryDetailCustomMethodFragment extends BaseFragment<FragmentLotteryCustomDetailTwoBinding> {

    private static final String TYPE = "param";
    private String mTabType = "";
    private int mType = 1;
    private LotteryDetailActivity activity;
    private LinearLayoutManager mLayoutManager;

    @Override
    public int setContent() {
        return R.layout.fragment_lottery_custom_detail_two;
    }

    public static LotteryDetailCustomMethodFragment newInstance(int param) {
        LotteryDetailCustomMethodFragment fragment = new LotteryDetailCustomMethodFragment();
        Bundle args = new Bundle();
        args.putInt(TYPE, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LotteryDetailActivity) context;
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


        /**
         * 因为启动时先走loadData()再走onActivityCreated，
         * 所以此处要额外调用load(),不然最初不会加载内容
         */
        loadData();
    }

    @Override
    protected void loadData() {
        DebugUtil.error("-----loadData");
        if (!mIsVisible) {
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
        bindingView.srlLotterydetail.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadCustomData();
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    private void loadCustomData() {
        if (mType == 1) {
            bindingView.tvTitle.setText("双色球怎样玩？");
            bindingView.playMethod.setText(getString(R.string.play_method_doublecolor));
        } else if (mType == 2) {
            bindingView.tvTitle.setText("大乐透怎样玩？");
//            bindingView.playMethod.setText(getString(R.string.play_method_daletou));
        } else if (mType == 3) {
            bindingView.tvTitle.setText("排列五怎样玩？");
            bindingView.playMethod.setText(getString(R.string.play_method_rankfive));
        } else {
            bindingView.tvTitle.setText("排列三怎样玩？");
//            bindingView.playMethod.setText(getString(R.string.play_method_kuaisan));
        }
        bindingView.srlLotterydetail.setRefreshing(false);

    }


    @Override
    protected void onRefresh() {
        bindingView.srlLotterydetail.setRefreshing(true);
        loadCustomData();
    }

}
