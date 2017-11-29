package com.mrice.txl.appthree;

import android.os.Bundle;

import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.databinding.ActivityMethodBinding;


/**
 * Created by cai on 2017/9/9.
 */

public class MethodActivity extends BaseActivity<ActivityMethodBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method);


        setTitle("11选5技巧知晓");

        showContentView();

        bindingView.playMethod.setText(R.string.play_method_shiyixuanwu);

    }


}
