package com.mrice.txl.appthree.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.databinding.NavIntroductionPageBinding;
import com.mrice.txl.appthree.utils.ShareUtils;
import com.mrice.txl.appthree.view.statusbar.StatusBarUtil;

/**
 * Created by cai on 2017/8/6.
 */

public class NavIntroductionActivity extends AppCompatActivity {

    NavIntroductionPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.nav_introduction_page);

        binding.toolbarLayout.setTitle(getString(R.string.app_name));
        StatusBarUtil.setTranslucentForImageView(this, 0, binding.toolbar);
        binding.fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.share(v.getContext(), R.string.string_share_text);
        }
        });
    }

    public static void startHome(Context mContext) {
        Intent intent = new Intent(mContext, NavIntroductionActivity.class);
        mContext.startActivity(intent);
    }
}
