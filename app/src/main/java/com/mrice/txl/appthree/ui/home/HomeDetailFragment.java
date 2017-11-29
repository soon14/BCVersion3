package com.mrice.txl.appthree.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.databinding.FragmentHomeDetailsBinding;

/**
 * Created by app on 2017/11/29.
 */
public class HomeDetailFragment extends BaseFragment<FragmentHomeDetailsBinding>{

    private int position;

    public static HomeDetailFragment newInstance(int position, String title) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putInt("position", position);
        HomeDetailFragment fragment = new HomeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        Bundle args= getArguments();
        if(args!=null){
            position=args.getInt("position");
        }
    }

    @Override
    public int setContent() {
        return R.layout.fragment_home_details;
    }



}
