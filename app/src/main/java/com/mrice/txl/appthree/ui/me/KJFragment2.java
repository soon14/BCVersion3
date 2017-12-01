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

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.HomeAdapter;
import com.mrice.txl.appthree.bean.MultipleItem;
import com.mrice.txl.appthree.ui.home.PubData;
import com.mrice.txl.appthree.view.webview.WebViewActivity;

import java.util.List;

/**
 * Created by Mr on 2017/12/1.
 */

public class KJFragment2 extends Fragment {

    private List<MultipleItem> datas;
    private HomeAdapter adapter;
    private RecyclerView recyclerView;

    public KJFragment2() {
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
        return inflater.inflate(R.layout.layout_kj2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.mlv);
        datas = PubData.getPageData2();
        adapter = new HomeAdapter(datas);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //条目点击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent i = new Intent(getActivity(), KJDetailsActivity.class);
                    if ("双色球".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 1);
                    } else if ("七乐彩".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 2);
                    } else if ("大乐透".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 3);
                    }  else if ("七星彩".equals(datas.get(position).getTitle())) {
                            i.putExtra("position", 4);
                    } else if ("排列三".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 5);
                    } else if ("排列五".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 6);
                    } else if ("排列五".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 7);
                    } else if ("排列五".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 8);
                    }
                    startActivity(i);

            }
        });
    }
}
