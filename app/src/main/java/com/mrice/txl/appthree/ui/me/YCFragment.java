package com.mrice.txl.appthree.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.YCAdapter;
import com.mrice.txl.appthree.bean.YCItem;
import com.mrice.txl.appthree.ui.LotteryDetailActivity;
import com.mrice.txl.appthree.ui.home.PubData;
import com.mrice.txl.appthree.ui.zoushi.LottoTrendActivity;
import com.mrice.txl.appthree.view.webview.WebViewActivity;

import java.util.List;

/**
 * Created by app on 2017/12/1.
 */
public class YCFragment extends Fragment implements View.OnClickListener {

    private YCAdapter adapter;
    private RecyclerView recyclerView;
    private List<YCItem> data;
    private LinearLayout l_ssq, l_dlt, l_qxc;

    public YCFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yc, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        l_ssq = (LinearLayout) getActivity().findViewById(R.id.l_ssq);
        l_dlt = (LinearLayout) getActivity().findViewById(R.id.l_dlt);
        l_qxc = (LinearLayout) getActivity().findViewById(R.id.l_qxc);
        l_ssq.setOnClickListener(this);
        l_dlt.setOnClickListener(this);
        l_qxc.setOnClickListener(this);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.rlvv);
        data = PubData.getYcData();
        adapter = new YCAdapter(R.layout.yc_item, data);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //条目点击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                WebViewActivity.loadUrl(getContext(), data.get(position).getContent(), "专家预测");
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity(), LottoTrendActivity.class);
        switch (v.getId()) {
            case R.id.l_ssq:
                i.putExtra("position", 1);
                break;
            case R.id.l_dlt:
                i.putExtra("position", 2);
                break;
            case R.id.l_qxc:
                i.putExtra("position", 3);
                break;
        }
        startActivity(i);
    }
}
