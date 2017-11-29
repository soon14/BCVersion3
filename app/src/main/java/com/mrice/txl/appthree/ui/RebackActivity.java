package com.mrice.txl.appthree.ui;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.RebackAdapter;
import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.databinding.LayoutRebackBinding;
import com.mrice.txl.appthree.ui.purchase.RebackItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by app on 2017/10/12.
 */
public class RebackActivity extends BaseActivity<LayoutRebackBinding> {

    private RebackAdapter rebackAdapter;
    private int type = -1;
    private List<RebackItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_reback);
        showContentView();
        type = getIntent().getIntExtra("type", type);
        setTitle("往期回顾");
        bindingView.lv.setPullRefreshEnabled(false);
        bindingView.lv.setLoadingMoreEnabled(false);
        bindingView.lv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        // 需加，不然滑动不流畅
        bindingView.lv.setNestedScrollingEnabled(false);
        bindingView.lv.setHasFixedSize(false);
        bindingView.lv.setItemAnimator(new DefaultItemAnimator());
        rebackAdapter = new RebackAdapter(this);
        bindingView.lv.setAdapter(rebackAdapter);
        switch (type) {
            case 1:
                list = createListDLT();
                bindingView.title.setText("大乐透");
                break;
            case 2:
                list = createListSSQ();
                bindingView.title.setText("双色球");
                break;
            case 3:
                list = createList7LC();
                bindingView.title.setText("七乐彩");
                break;
            case 4:
                list = createList7XC();
                bindingView.title.setText("七星彩");
                break;
        }
        rebackAdapter.addAll(list);
        rebackAdapter.notifyDataSetChanged();
    }

    private List<RebackItem> createListDLT() {
        List<RebackItem> l = new ArrayList<>();
        RebackItem r = new RebackItem();
        r.setQq("17118");
        r.setBall1("05");
        r.setBall2("07");
        r.setBall3("13");
        r.setBall4("29");
        r.setBall5("35");
        r.setBall6("03");
        r.setBall7("08");
        r.setType(1);
        l.add(r);

        RebackItem rr;
        for (int i = 17117; i > 17080; i--) {
            int[] s = randomCommon(1, 33, 7);
            rr = new RebackItem();
            rr.setQq("" + i);
            rr.setBall1(exchange(s[0]));
            rr.setBall2(exchange(s[1]));
            rr.setBall3(exchange(s[2]));
            rr.setBall4(exchange(s[3]));
            rr.setBall5(exchange(s[4]));
            rr.setBall6(exchange(s[5]));
            rr.setBall7(exchange(s[6]));
            rr.setType(1);
            l.add(rr);
        }
        return l;
    }

    private List<RebackItem> createListSSQ() {
        List<RebackItem> l = new ArrayList<>();
        RebackItem r = new RebackItem();
        r.setQq("17119");
        r.setBall1("09");
        r.setBall2("16");
        r.setBall3("21");
        r.setBall4("25");
        r.setBall5("26");
        r.setBall6("31");
        r.setBall7("14");
        r.setType(2);
        l.add(r);

        RebackItem r2 = new RebackItem();
        r2.setQq("17118");
        r2.setBall1("08");
        r2.setBall2("09");
        r2.setBall3("15");
        r2.setBall4("22");
        r2.setBall5("30");
        r2.setBall6("33");
        r2.setBall7("16");
        r2.setType(2);
        l.add(r2);

        RebackItem r3 = new RebackItem();
        r3.setQq("17117");
        r3.setBall1("01");
        r3.setBall2("02");
        r3.setBall3("08");
        r3.setBall4("11");
        r3.setBall5("14");
        r3.setBall6("21");
        r3.setBall7("09");
        r3.setType(2);
        l.add(r3);

        RebackItem r4 = new RebackItem();
        r4.setQq("17116");
        r4.setBall1("05");
        r4.setBall2("07");
        r4.setBall3("13");
        r4.setBall4("29");
        r4.setBall5("35");
        r4.setBall6("03");
        r4.setBall7("08");
        r4.setType(2);
        l.add(r4);

        RebackItem r5 = new RebackItem();
        r5.setQq("17115");
        r5.setBall1("04");
        r5.setBall2("10");
        r5.setBall3("11");
        r5.setBall4("25");
        r5.setBall5("30");
        r5.setBall6("31");
        r5.setBall7("01");
        r5.setType(2);
        l.add(r5);

        RebackItem r6 = new RebackItem();
        r6.setQq("17114");
        r6.setBall1("06");
        r6.setBall2("12");
        r6.setBall3("13");
        r6.setBall4("15");
        r6.setBall5("18");
        r6.setBall6("26");
        r6.setBall7("13");
        r6.setType(2);
        l.add(r6);

        RebackItem rr;
        for (int i = 17113; i > 17080; i--) {
            int[] s = randomCommon(1, 33, 7);
            rr = new RebackItem();
            rr.setQq("" + i);
            rr.setBall1(exchange(s[0]));
            rr.setBall2(exchange(s[1]));
            rr.setBall3(exchange(s[2]));
            rr.setBall4(exchange(s[3]));
            rr.setBall5(exchange(s[4]));
            rr.setBall6(exchange(s[5]));
            rr.setBall7(exchange(s[6]));
            rr.setType(2);
            l.add(rr);
        }


        return l;
    }

    private List<RebackItem> createList7LC() {
        List<RebackItem> l = new ArrayList<>();
        RebackItem r = new RebackItem();
        r.setQq("17118");
        r.setBall1("05");
        r.setBall2("07");
        r.setBall3("13");
        r.setBall4("29");
        r.setBall5("35");
        r.setBall6("03");
        r.setBall7("08");
        r.setType(3);
        l.add(r);
        RebackItem rr;
        for (int i = 17117; i > 17080; i--) {
            int[] s = randomCommon(1, 33, 7);
            rr = new RebackItem();
            rr.setQq("" + i);
            rr.setBall1(exchange(s[0]));
            rr.setBall2(exchange(s[1]));
            rr.setBall3(exchange(s[2]));
            rr.setBall4(exchange(s[3]));
            rr.setBall5(exchange(s[4]));
            rr.setBall6(exchange(s[5]));
            rr.setBall7(exchange(s[6]));
            rr.setType(3);
            l.add(rr);
        }
        return l;
    }

    private List<RebackItem> createList7XC() {
        List<RebackItem> l = new ArrayList<>();
        RebackItem r = new RebackItem();
        r.setQq("17119");
        r.setBall1("2");
        r.setBall2("6");
        r.setBall3("6");
        r.setBall4("5");
        r.setBall5("0");
        r.setBall6("3");
        r.setBall7("6");
        r.setType(4);
        l.add(r);
        RebackItem rr;
        for (int i = 17118; i > 17080; i--) {
            int[] s = randomCommon(0, 9, 7);
            rr = new RebackItem();
            rr.setQq("" + i);
            rr.setBall1(s[0] + "");
            rr.setBall2(s[1] + "");
            rr.setBall3(s[2] + "");
            rr.setBall4(s[3] + "");
            rr.setBall5(s[4] + "");
            rr.setBall6(s[5] + "");
            rr.setBall7(s[6] + "");
            rr.setType(4);
            l.add(rr);
        }
        return l;
    }

    private String exchange(int n) {
        String s = String.valueOf(n);
        if (s.length() == 1) {
            return "0" + s;
        }
        return s;
    }


    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
