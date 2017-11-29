package com.mrice.txl.appthree;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.databinding.FragmentBeijingBinding;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.cocosw.bottomsheet.BottomSheet;

import java.util.HashMap;
import java.util.LinkedList;

import static com.mrice.txl.appthree.R.id.santonghao;

/**
 * Created by cai on 2017/8/30.
 */

public class BeijingFragment extends BaseFragment<FragmentBeijingBinding> {
    /**
     * 是否选中
     */
    private boolean isSelected;


    /**
     * 球的随机选中个数
     */
    private int selectCount = 0;

    /**
     * 一行放置球的个数
     */
    private int average = 7;
    /**
     * 选中结果前缀
     */
    private String resultPrefix = "";
    /**
     * container中总个数
     */
    private int eachContentCount;

    private StringBuilder stringBuilder;

    private HashMap<Integer, String> map = new HashMap<Integer, String>();

    private String[] names = new String[]{"和值", "三同号单选", "三不同号", "三连号通选", "二同号复选", "二不同号"};
    private int[] ids = new int[]{R.id.hezhi, santonghao, R.id.sanbutong, R.id.sanlianhaotongxuan, R.id.ertonghaofuxuan, R.id.erbutong};


    @Override
    public int setContent() {
        return R.layout.fragment_beijing;
    }


    private void initData() {
        stringBuilder = new StringBuilder();
        bindingView.name.setText("和值");
        for (int i = 0; i < ids.length; i++) {
            map.put(ids[i], names[i]);
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showContentView();

        initData();
        hezhi();
        bindingView.llChooseCatalogue.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                new BottomSheet.Builder(getContext(), R.style.BottomSheet_StyleDialog).title("选择分类").sheet(R.menu.gank_bottomsheet).listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case R.id.hezhi:
                                hezhi();
                                break;
                            case santonghao:
                                santonghaodanxuan();
                                break;
                            case R.id.sanbutong:
                                sanbutonghao();
                                break;
                            case R.id.sanlianhaotongxuan:
                                sanlianhaotongxuan();
                                break;
                            case R.id.ertonghaofuxuan:
                                ertonghaofuxuan();
                                break;
                            case R.id.erbutong:
                                erbutonghao();
                                break;

                        }
                        bindingView.name.setText(map.get(which));
                    }
                }).show();
            }
        });

        bindingView.clear.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setSelected(false);
                        bindingView.result.setText("共" + 0 + "注  " + 0 + "元");
                    }
                }
            }
        });

    }

    private void hezhi() {
        clearUsing();
        bindingView.container.removeAllViews();
        //container中线性布局容器
        LinearLayout all = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin = 50;
        layoutParams.topMargin = 50;
        all.setLayoutParams(layoutParams);
        all.setGravity(Gravity.CENTER_HORIZONTAL);
        all.setBackgroundResource(R.drawable.bg_ball);
        all.setOrientation(LinearLayout.VERTICAL);

        eachContentCount = 18;
        all.removeAllViews();
        stringBuilder.append(resultPrefix);

        //线性布局容器中装球的子容器的布局参数
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
        layoutParams1.setMargins(20, 30, 20, 30);
        //每行球满7个换行的Linearlayout
        LinearLayout ll = null;
        for (int j = 2; j < eachContentCount; j++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.width = 0;
            params.height = 120;
            params.weight = 1;
            params.leftMargin = 30;
            final TextView textView = new TextView(getContext());
            textView.setTag(j);
            list.add(textView);
            textView.setBackgroundResource(R.drawable.ballchoose_selector);
            textView.setTextColor(getResources().getColorStateList(R.color.text_selector));
            textView.setSelected(false);
            textView.setTextSize(17);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setSelected(!textView.isSelected());
                    for (TextView tv : list) {
                        if (tv.isSelected()) {
                            selectCount++;
                        }
                    }
                    bindingView.result.setText("共" + selectCount + "注  " + selectCount * 2 + "元");
                    selectCount = 0;
                }
            });
            textView.setText("" + (j + 1));
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(params);


            if (j == 2 || j == 10) {
                ll = new LinearLayout(getContext());
                ll.setGravity(LinearLayout.HORIZONTAL);
                ll.setLayoutParams(layoutParams1);
                all.addView(ll);
            }
            if (ll != null)
                ll.addView(textView);
        }
        bindingView.container.addView(all);
        bindingView.money.setText("单注奖金 9-240元");

    }

    private String[] data_sthdx = new String[]{"111", "222", "333", "444", "555", "666"};

    private void santonghaodanxuan() {
        clearUsing();
        bindingView.container.removeAllViews();
        //container中线性布局容器
        LinearLayout all = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin = 50;
        layoutParams.topMargin = 50;
        all.setLayoutParams(layoutParams);
        all.setGravity(Gravity.CENTER_HORIZONTAL);
        all.setBackgroundResource(R.drawable.bg_ball);
        all.setOrientation(LinearLayout.VERTICAL);

        eachContentCount = data_sthdx.length;
        all.removeAllViews();
        stringBuilder.append(resultPrefix);
        //线性布局容器中装球的子容器的布局参数
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
        layoutParams1.setMargins(20, 30, 20, 30);
        //每行球满7个换行的Linearlayout
        LinearLayout ll = null;
        for (int j = 0; j < eachContentCount; j++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.width = 0;
            params.height = 120;
            params.weight = 1;
            params.leftMargin = 30;
            final TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.ballchoose_selector);
            textView.setTextColor(getResources().getColorStateList(R.color.text_selector));
            textView.setSelected(false);
            textView.setTextSize(17);
            list.add(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setSelected(!textView.isSelected());
                    for (TextView tv : list) {
                        if (tv.isSelected()) {
                            selectCount++;
                        }
                    }
                    bindingView.result.setText("共" + selectCount + "注  " + selectCount * 2 + "元");
                    selectCount = 0;
                }
            });
            textView.setText(data_sthdx[j]);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(params);
            if (j == 0) {
                ll = new LinearLayout(getContext());
                ll.setGravity(LinearLayout.HORIZONTAL);
                ll.setLayoutParams(layoutParams1);
                all.addView(ll);
            }
            ll.addView(textView);
        }

        bindingView.container.addView(all);
        bindingView.money.setText("单注奖金 240元");
    }

    private void clearUsing() {
        bindingView.result.setText("共" + 0 + "注  " + 0 + "元");
        list.clear();
    }

    private void sanbutonghao() {
        clearUsing();
        bindingView.container.removeAllViews();
        //container中线性布局容器
        LinearLayout all = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin = 50;
        layoutParams.topMargin = 50;
        all.setLayoutParams(layoutParams);
        all.setGravity(Gravity.CENTER_HORIZONTAL);
        all.setBackgroundResource(R.drawable.bg_ball);
        all.setOrientation(LinearLayout.VERTICAL);

        eachContentCount = 6;
        all.removeAllViews();
        stringBuilder.append(resultPrefix);
        //线性布局容器中装球的子容器的布局参数
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
        layoutParams1.setMargins(20, 30, 20, 30);
        //每行球满7个换行的Linearlayout
        LinearLayout ll = null;
        for (int j = 0; j < eachContentCount; j++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.width = 0;
            params.height = 120;
            params.weight = 1;
            params.leftMargin = 30;
            final TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.ballchoose_selector);
            textView.setTextColor(getResources().getColorStateList(R.color.text_selector));
            textView.setSelected(false);
            textView.setTextSize(17);
            list.add(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setSelected(!textView.isSelected());
                    for (TextView tv : list) {
                        if (tv.isSelected()) {
                            selectCount++;
                        }
                    }
                    bindingView.result.setText("共" + combination(selectCount, 3) + "注  " + combination(selectCount, 3) * 2 + "元");
                    selectCount = 0;
                }
            });
            textView.setText("" + (j + 1));
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(params);
            if (j == 0) {
                ll = new LinearLayout(getContext());
                ll.setGravity(LinearLayout.HORIZONTAL);
                ll.setLayoutParams(layoutParams1);
                all.addView(ll);
            }
            ll.addView(textView);
        }

        bindingView.container.addView(all);
        bindingView.money.setText("单注奖金 40元");
    }


    private String[] data_slhtx = new String[]{"123", "234", "345", "456"};
    private LinkedList<TextView> list = new LinkedList<>();

    private void sanlianhaotongxuan() {
        clearUsing();
        bindingView.container.removeAllViews();
        //container中线性布局容器
        LinearLayout all = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin = 50;
        layoutParams.topMargin = 50;
        all.setLayoutParams(layoutParams);
        all.setGravity(Gravity.CENTER_HORIZONTAL);
        all.setBackgroundResource(R.drawable.bg_ball);
        all.setOrientation(LinearLayout.VERTICAL);

        eachContentCount = data_slhtx.length;
        all.removeAllViews();
        stringBuilder.append(resultPrefix);
        //线性布局容器中装球的子容器的布局参数
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
        layoutParams1.setMargins(20, 30, 20, 30);
        //每行球满7个换行的Linearlayout
        LinearLayout ll = null;
        for (int j = 0; j < eachContentCount; j++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.width = 0;
            params.height = 120;
            params.weight = 1;
            params.leftMargin = 30;
            final TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.ballchoose_selector);
            textView.setTextColor(getResources().getColorStateList(R.color.text_selector));
            textView.setSelected(false);
            textView.setTextSize(17);
            list.add(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (TextView textView : list) {
                        textView.setSelected(!textView.isSelected());
                    }
                    selectCount = textView.isSelected() ? 1 : 0;
                    bindingView.result.setText("共" + selectCount + "注  " + selectCount * 2 + "元");
                    selectCount = 0;
                }
            });
            textView.setText("" + data_slhtx[j]);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(params);
            if (j == 0) {
                ll = new LinearLayout(getContext());
                ll.setGravity(LinearLayout.HORIZONTAL);
                ll.setLayoutParams(layoutParams1);
                all.addView(ll);
            }
            ll.addView(textView);
        }

        bindingView.container.addView(all);
        bindingView.money.setText("单注奖金 10元");
    }

    private String[] ethfx = new String[]{"11", "22", "33", "44", "55", "66"};

    private void ertonghaofuxuan() {
        clearUsing();
        bindingView.container.removeAllViews();
        //container中线性布局容器
        LinearLayout all = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin = 50;
        layoutParams.topMargin = 50;
        all.setLayoutParams(layoutParams);
        all.setGravity(Gravity.CENTER_HORIZONTAL);
        all.setBackgroundResource(R.drawable.bg_ball);
        all.setOrientation(LinearLayout.VERTICAL);

        eachContentCount = ethfx.length;
        all.removeAllViews();
        stringBuilder.append(resultPrefix);
        //线性布局容器中装球的子容器的布局参数
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
        layoutParams1.setMargins(20, 30, 20, 30);
        //每行球满7个换行的Linearlayout
        LinearLayout ll = null;
        for (int j = 0; j < eachContentCount; j++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.width = 0;
            params.height = 120;
            params.weight = 1;
            params.leftMargin = 30;
            final TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.ballchoose_selector);
            textView.setTextColor(getResources().getColorStateList(R.color.text_selector));
            textView.setSelected(false);
            textView.setTextSize(17);
            list.add(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setSelected(!textView.isSelected());
                    for (TextView tv : list) {
                        if (tv.isSelected()) {
                            selectCount++;
                        }
                    }
                    bindingView.result.setText("共" + selectCount + "注  " + selectCount * 2 + "元");
                    selectCount = 0;
                }
            });
            textView.setText("" + ethfx[j]);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(params);
            if (j == 0) {
                ll = new LinearLayout(getContext());
                ll.setGravity(LinearLayout.HORIZONTAL);
                ll.setLayoutParams(layoutParams1);
                all.addView(ll);
            }
            ll.addView(textView);
        }

        bindingView.container.addView(all);
        bindingView.money.setText("单注奖金 15元");
    }

    private void erbutonghao() {
        clearUsing();
        bindingView.container.removeAllViews();
        //container中线性布局容器
        LinearLayout all = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.bottomMargin = 50;
        layoutParams.topMargin = 50;
        all.setLayoutParams(layoutParams);
        all.setGravity(Gravity.CENTER_HORIZONTAL);
        all.setBackgroundResource(R.drawable.bg_ball);
        all.setOrientation(LinearLayout.VERTICAL);

        eachContentCount = 6;
        all.removeAllViews();
        stringBuilder.append(resultPrefix);
        //线性布局容器中装球的子容器的布局参数
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); // 每行的水平LinearLayout
        layoutParams1.setMargins(20, 30, 20, 30);
        //每行球满7个换行的Linearlayout
        LinearLayout ll = null;
        for (int j = 0; j < eachContentCount; j++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.width = 0;
            params.height = 120;
            params.weight = 1;
            params.leftMargin = 30;
            final TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.ballchoose_selector);
            textView.setTextColor(getResources().getColorStateList(R.color.text_selector));
            textView.setSelected(false);
            textView.setTextSize(17);
            list.add(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setSelected(!textView.isSelected());
                    for (TextView tv : list) {
                        if (tv.isSelected()) {
                            selectCount++;
                        }
                    }
                    bindingView.result.setText("共" + combination(selectCount, 2) + "注  " + combination(selectCount, 2) * 2 + "元");
                    selectCount = 0;
                }
            });
            textView.setText("" + (j + 1));
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(params);
            if (j == 0) {
                ll = new LinearLayout(getContext());
                ll.setGravity(LinearLayout.HORIZONTAL);
                ll.setLayoutParams(layoutParams1);
                all.addView(ll);
            }
            ll.addView(textView);
        }

        bindingView.container.addView(all);
        bindingView.money.setText("单注奖金 8元");
    }

    /**
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
     *
     * @param n
     * @param m
     * @return
     */
    public static long combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     *
     * @param n
     * @return
     */
    private static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }
}
