package com.mrice.txl.appthree.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mrice.txl.appthree.R;

public class KJFragment extends Fragment implements View.OnClickListener {

    private LinearLayout layoutSSQ;
    private LinearLayout layoutQLC;
    private LinearLayout layoutDLT;
    private LinearLayout layoutQXC;
    private LinearLayout layoutPL3;
    private LinearLayout layoutPL5;
    private LinearLayout layoutK3;
    private LinearLayout layout11X5;

    public KJFragment() {
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
        return inflater.inflate(R.layout.f_three, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        layoutSSQ = (LinearLayout) getView().findViewById(R.id.layoutSSQ);
        layoutQLC = (LinearLayout) getView().findViewById(R.id.layoutQLC);
        layoutDLT = (LinearLayout) getView().findViewById(R.id.layoutDLT);
        layoutQXC = (LinearLayout) getView().findViewById(R.id.layoutQXC);
        layoutPL3 = (LinearLayout) getView().findViewById(R.id.layoutPL3);
        layoutPL5 = (LinearLayout) getView().findViewById(R.id.layoutPL5);
        layoutK3 = (LinearLayout) getView().findViewById(R.id.layoutK3);
        layout11X5 = (LinearLayout) getView().findViewById(R.id.layout11X5);
        layoutSSQ.setOnClickListener(this);
        layoutQLC.setOnClickListener(this);
        layoutDLT.setOnClickListener(this);
        layoutQXC.setOnClickListener(this);
        layoutPL3.setOnClickListener(this);
        layoutPL5.setOnClickListener(this);
        layoutK3.setOnClickListener(this);
        layout11X5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity(), KJDetailsActivity.class);
        switch (v.getId()){
            case R.id.layoutSSQ:
                i.putExtra("position", 1);
                break;
            case R.id.layoutQLC:
                i.putExtra("position", 2);
                break;
            case R.id.layoutDLT:
                i.putExtra("position", 3);
                break;
            case R.id.layoutQXC:
                i.putExtra("position", 4);
                break;
            case R.id.layoutPL3:
                i.putExtra("position", 5);
                break;
            case R.id.layoutPL5:
                i.putExtra("position", 6);
                break;
            case R.id.layoutK3:
                i.putExtra("position", 7);
                break;
            case R.id.layout11X5:
                i.putExtra("position", 8);
                break;

        }
        startActivity(i);
    }
}
