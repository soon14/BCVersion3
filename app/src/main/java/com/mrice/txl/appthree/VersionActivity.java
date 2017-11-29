package com.mrice.txl.appthree;

import android.os.Bundle;

import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.databinding.ActivityVersionBinding;

public class VersionActivity  extends BaseActivity<ActivityVersionBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        showContentView();
        setTitle("版本");
    }

}
