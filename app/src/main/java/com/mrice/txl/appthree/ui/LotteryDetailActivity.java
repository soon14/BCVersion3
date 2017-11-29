package com.mrice.txl.appthree.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.app.IntentValue;
import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.databinding.ActivityLotteryDetailBinding;

/**
 * Created by cai on 2017/8/7.
 */

public class LotteryDetailActivity extends BaseActivity<ActivityLotteryDetailBinding> {

    private FrameLayout container;
    private String mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery_detail);
        if (getIntent() != null) {
            mType = getIntent().getStringExtra(IntentValue.lottery_type);
            setTitle(mType);
        }
        getSupportFragmentManager().beginTransaction().add(R.id.container, new LotteryDetailFragment()).commit();

    }

    public String getType(){
        return mType;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
