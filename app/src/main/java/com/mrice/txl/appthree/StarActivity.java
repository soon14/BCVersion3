package com.mrice.txl.appthree;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.mrice.txl.appthree.adapter.StarAdapter;
import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.databinding.ActivityStarBinding;
import com.mrice.txl.appthree.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class StarActivity extends BaseActivity<ActivityStarBinding> {

    private List<String> data=new ArrayList<>();
    private StarAdapter starAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);
        showContentView();
        setTitle("收藏");
        String str= SPUtils.getString("star","");
        Log.e("---",str);
        if(!TextUtils.isEmpty(str)){
            String[] item=str.split(";");
            int s=item.length;
            if(s>0){
                for(int i=0;i<s;i++){
                    if(!TextUtils.isEmpty(item[i])){
                        data.add(item[i]);
                    }
                }
            }else {
                Toast.makeText(getApplicationContext(),"暂无收藏内容",Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(getApplicationContext(),"暂无收藏内容",Toast.LENGTH_LONG).show();
        }

        starAdapter=new StarAdapter(this,data);
        bindingView.lv.setAdapter(starAdapter);
    }
}
