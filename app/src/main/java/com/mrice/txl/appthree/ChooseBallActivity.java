package com.mrice.txl.appthree;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.databinding.ActivityChooseBinding;
import com.mrice.txl.appthree.utils.SPUtils;

import java.util.LinkedList;

/**
 * Created by cai on 2017/8/30.
 */

public class ChooseBallActivity extends BaseActivity<ActivityChooseBinding> {


    private int mType = 1;

    private LinkedList list;
    /**
     * 红蓝球最大的个数
     */
    private int redMax = 33;
    private int blueMax = 16;

    /**
     * 球的随机选中个数
     */
    private int redballCount = 5;
    private int blueballCount = 1;

    /**
     * 一行放置球的个数
     */
    private int average = 8;

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

    private int w = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        showContentView();
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        w = outMetrics.widthPixels;

        if (getIntent() != null) {
            mType = getIntent().getIntExtra(Constants.MCHOOSETYPE, 2);
        }
        stringBuilder = new StringBuilder();

        initView();

        chooseBall(mType);

        bindingView.btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringBuilder.delete(0, stringBuilder.length());
                chooseBall(mType);
            }
        });

        bindingView.btnSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "收藏成功", Toast.LENGTH_SHORT).show();
                String str = SPUtils.getString("star", "");
                SPUtils.putString("star", mType + "|" + stringBuilder.toString() + ";" + str);
            }
        });
    }

    private void initView() {
        String title = "";
        switch (mType) {
            case 1:
                title = "双色球";
                bindingView.title.setText("规则：至少选6个红球，1个蓝球");
                break;
            case 2:
                title = "大乐透";
                bindingView.title.setText("规则：至少选5个红球，2个蓝球");
                break;
            case 3:
                title = "快3";
                bindingView.title.setText("规则：猜开奖号码相加的和");
                break;
            case 4:
                title = "排列三";
                bindingView.title.setText("规则：请选三个球");
                break;
            case 5:
                title = "排列五";
                bindingView.title.setText("规则：请选五个球");
                break;
            case 7:
                title = "七乐彩";
                bindingView.title.setText("规则：至少选7个号码");
                break;
            case 8:
                title = "七星彩";
                bindingView.title.setText("规则：至少选7个号码");
                break;
        }
        setTitle(title);
    }


    private void chooseBall(int containerNum) {
        bindingView.container.removeAllViews();
        containerNum = mType == 1 ? 2 : mType;
        if (mType == 3 || mType == 7 || mType == 4 || mType == 5 || mType == 8) {
            containerNum = 1;
        }
        for (int i = 0; i < containerNum; i++) {
            //container中线性布局容器
            LinearLayout all = new LinearLayout(ChooseBallActivity.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.bottomMargin = 10;
            all.setLayoutParams(layoutParams);
            all.setGravity(Gravity.CENTER_HORIZONTAL);
            all.setBackgroundResource(R.drawable.bg_ball);
            all.setOrientation(LinearLayout.VERTICAL);

            if (mType == 1 || mType == 2) {
                blueballCount = mType;
                blueMax = (mType == 1 ? blueMax : 12);
                redMax = (mType == 1 ? redMax : 35);
                redballCount = (mType == 1 ? 6 : redballCount);
                eachChooseContentCount = (i == 0 ? redballCount : blueballCount);
                eachContentCount = (i == 0 ? redMax : blueMax);
                resultPrefix = (i == 0 ? "红球：  " : "\n\n蓝球：  ");
                isBlue = !(i == 0);
            } else if (mType == 3) {
                eachChooseContentCount = 1;
                eachContentCount = 14;
                redballCount = 14;
                resultPrefix = (i == 0 ? "相加和为:   " : "");
                isBlue = false;
            } else if (mType == 4) {
                eachChooseContentCount = 3;
                eachContentCount = 14;
                redballCount = 14;
                resultPrefix = (i == 0 ? "排列为:   " : "");
                isBlue = false;
            } else if (mType == 5) {
                eachChooseContentCount = 5;
                eachContentCount = 14;
                redballCount = 14;
                resultPrefix = (i == 0 ? "排列为:   " : "");
                isBlue = false;
            } else if (mType == 7 || mType == 8) {
                eachChooseContentCount = 7;
                eachContentCount = 30;
                redballCount = 30;
                resultPrefix = (i == 0 ? "组号:   " : "");
                isBlue = false;
            } else {
                eachChooseContentCount = 1;
                eachContentCount = 9;
//                if (mType == 3)
//                    eachContentCount = 6;
                resultPrefix = (i == 0 ? "组号:   " : "");
                isBlue = false;
            }
            all.removeAllViews();
            stringBuilder.append(resultPrefix);
            list = new LinkedList();
            for (int a = 0; a < eachChooseContentCount; a++) {
                int random = (int) (Math.random() * (eachContentCount - 1) + 1);
                if (!list.contains(random)) {
                    list.add(random);
                    if (mType == 3) {
                        stringBuilder.append(random + 3 + "  ");
                    } else {
                        stringBuilder.append(random + "  ");
                    }
                    if (a == eachChooseContentCount - 1)
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    continue;
                }
                a--;
            }
            //线性布局容器中装球的子容器的布局参数
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
            layoutParams1.setMargins(5, 20, 5, 20);
            //每行球满7个换行的Linearlayout
            LinearLayout ll = null;
            for (int j = 0; j < eachContentCount; j++) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.width = (w - 100) / average;
                params.height = (w - 100) / average;
                params.leftMargin = 5;
                params.rightMargin = 5;
                TextView textView = new TextView(this);
                textView.setBackgroundResource(isBlue ? R.drawable.ballchoose_blueselector2 : R.drawable.ballchoose_selector2);
                textView.setTextColor(isBlue ? getResources().getColorStateList(R.color.text_blueselector) : getResources().getColorStateList(R.color.text_selector));
                if (list.contains(j + 1)) {
                    textView.setSelected(true);
                }
                textView.setText("" + (j + 1));
                if (mType == 3) {
                    textView.setText("" + (j + 4));
                }
                textView.setGravity(Gravity.CENTER);
                textView.setLayoutParams(params);

                if (j % average == 0) {
                    ll = new LinearLayout(this);
                    ll.setOrientation(LinearLayout.HORIZONTAL);
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
