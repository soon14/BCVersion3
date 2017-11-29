package com.mrice.txl.appthree.ui.service;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.databinding.FragmentAwardBinding;

import java.util.LinkedList;

/**
 * Created by company on 2017/8/2.
 */

public class AwardFragment extends BaseFragment<FragmentAwardBinding> implements View.OnClickListener {


    private int mType = 1;

    private LinkedList list;
    /**
     * 红蓝球最大的个数
     */
    private int redMax = 32;
    private int blueMax = 16;

    /**
     * 球的随机选中个数
     */
    private int redballCount = 5;
    private int blueballCount = 1;

    /**
     * 一行放置球的个数
     */
    private int average = 7;

    /**
     * 所需要行数
     */
    private int row;
    /**
     * 选中结果前缀
     */
    private String resultPrefix = "";
    /**
     * 是否有蓝色球
     */
    private boolean isBlue;
    /**
     * container中选中个数
     */
    private int eachChooseContentCount;
    /**
     * container中总个数
     */
    private int eachContentCount;

    private StringBuilder stringBuilder;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showContentView();
        stringBuilder = new StringBuilder();

        mType = 3;
        chooseBall(mType);

        bindingView.choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringBuilder.delete(0, stringBuilder.length());
                chooseBall(mType);
            }
        });
    }


    @Override
    public int setContent() {
        return R.layout.fragment_award;
    }


    private void chooseBall(int containerNum) {
        bindingView.container.removeAllViews();
        containerNum = mType == 1 ? 2 : mType;
        for (int i = 0; i < containerNum; i++) {
            //container中线性布局容器
            LinearLayout all = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.bottomMargin = 20;
            all.setLayoutParams(layoutParams);
            all.setGravity(Gravity.CENTER_HORIZONTAL);
            all.setBackgroundResource(R.drawable.bg_ball);
            all.setOrientation(LinearLayout.VERTICAL);

            if (mType == 1 || mType == 2) {
                blueballCount = mType;
                blueMax = (mType == 1 ? blueMax : 12);
                redMax = (mType == 1 ? redMax : 35);
                eachChooseContentCount = (i == 0 ? redballCount : blueballCount);
                eachContentCount = (i == 0 ? redMax : blueMax);
                resultPrefix = (i == 0 ? "红球:   " : "蓝球： ");
                isBlue = !(i == 0);
            } else {
                eachChooseContentCount = 1;
                eachContentCount = 9;
                resultPrefix = (i == 0 ? "您所选择排列三号序列为:   " : "");
                isBlue = false;
            }
            all.removeAllViews();
            stringBuilder.append(resultPrefix);
            list = new LinkedList();
            for (int a = 0; a < eachChooseContentCount; a++) {
                int random = (int) (Math.random() * (eachContentCount - 1) + 1);
                if (!list.contains(random)) {
                    list.add(random);
                    stringBuilder.append(random + "，");
                    if (a == eachChooseContentCount - 1)
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    continue;
                }
                a--;
            }
            //线性布局容器中装球的子容器的布局参数
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
            layoutParams1.setMargins(20, 20, 20, 20);
            //每行球满7个换行的Linearlayout
            LinearLayout ll = null;
            for (int j = 0; j < eachContentCount; j++) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.width = 90;
                params.height = 90;
                params.leftMargin = 50;
                TextView textView = new TextView(getContext());
                textView.setBackgroundResource(isBlue ? R.drawable.ballchoose_blueselector : R.drawable.ballchoose_selector);
                textView.setTextColor(isBlue ? getResources().getColorStateList(R.color.text_blueselector) : getResources().getColorStateList(R.color.text_selector));
                if (list.contains(j + 1)) {
                    textView.setSelected(true);
                }
                textView.setText("" + (j + 1));
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(params);

                if (j % average == 0) {
                    ll = new LinearLayout(getContext());
                    ll.setGravity(LinearLayout.HORIZONTAL);
                    ll.setLayoutParams(layoutParams1);
                    all.addView(ll);
                    row++;
                }
                ll.addView(textView);
            }
            bindingView.container.addView(all);
        }
        bindingView.result.setText(stringBuilder.toString());
    }

}
