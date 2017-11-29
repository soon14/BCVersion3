package com.mrice.txl.appthree.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.databinding.FragmentLotteryDetailBinding;
import com.mrice.txl.appthree.view.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cai on 2017/8/7.
 */

public class LotteryDetailFragment extends BaseFragment<FragmentLotteryDetailBinding> {

    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);
    private String mType;
    private static final String TYPE = "param";
    private LotteryDetailActivity activity;

    public static LotteryDetailCustomFragment newInstance(String param) {
        LotteryDetailCustomFragment fragment = new LotteryDetailCustomFragment();
        Bundle args = new Bundle();
        args.putString(TYPE, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getString(TYPE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (LotteryDetailActivity) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showLoading();
        initFragmentList();
        /**
         * 注意使用的是：getChildFragmentManager，
         * 这样setOffscreenPageLimit()就可以添加上，保留相邻2个实例，切换时不会卡
         * 但会内存溢出，在显示时加载数据
         */
        MyFragmentPagerAdapter myAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), mFragments, mTitleList);
        bindingView.vpLottery.setAdapter(myAdapter);
        // 左右预加载页面的个数
        bindingView.vpLottery.setOffscreenPageLimit(2);
        myAdapter.notifyDataSetChanged();
        bindingView.tabLottery.setTabMode(TabLayout.MODE_FIXED);
        bindingView.tabLottery.setupWithViewPager(bindingView.vpLottery);
        showContentView();
    }

    @Override
    public int setContent() {
        return R.layout.fragment_lottery_detail;
    }

    private void initFragmentList() {
        mTitleList.add(getString(R.string.lottery_draw));
//        mTitleList.add(getString(R.string.play_method));
        mFragments.add(LotteryDetailCustomFragment.newInstance(getTypeId()));
//        mFragments.add(LotteryDetailCustomMethodFragment.newInstance(getTypeId()));
    }

    private HashMap<String, Integer> map = new HashMap();
    private String[] lotteryType = new String[]{"双色球", "大乐透", "排列五", "福彩快3", "11选5", "排列三", "七星彩", "七乐彩", "快乐彩"};

    public int getTypeId() {
        mType = activity.getType();
        for (int i = 0; i < lotteryType.length; i++) {
            map.put(lotteryType[i], i + 1);
        }
        return map.get(mType);
    }

    public void setType(String type) {
        this.mType = type;
    }
}
