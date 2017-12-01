package com.mrice.txl.appthree.ui.me;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.HomeAdapter;
import com.mrice.txl.appthree.bean.MultipleItem;
import com.mrice.txl.appthree.ui.home.PubData;

import java.util.List;

public class KJHistoryActivity extends AppCompatActivity {

    private int position = 0;
    private String title = "";
    private List<MultipleItem> datas;
    private HomeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kjhistory);
        position = getIntent().getIntExtra("position", position);
        title = getIntent().getStringExtra("title");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        recyclerView=(RecyclerView) findViewById(R.id.rlv);
        datas= PubData.getBallData(position);
        adapter=new HomeAdapter(datas);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
