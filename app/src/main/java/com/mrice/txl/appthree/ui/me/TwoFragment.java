package com.mrice.txl.appthree.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrice.txl.appthree.ChooseBallActivity;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.app.Constants;

public class TwoFragment extends Fragment implements View.OnClickListener {

    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private LinearLayout l5;
    private LinearLayout l6;
    private LinearLayout l7;
    private TextView tv;

    public TwoFragment() {
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
        return inflater.inflate(R.layout.f_two, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        l1 = (LinearLayout) getView().findViewById(R.id.layout1);
        l2 = (LinearLayout) getView().findViewById(R.id.layout2);
        l3 = (LinearLayout) getView().findViewById(R.id.layout3);
        l4 = (LinearLayout) getView().findViewById(R.id.layout4);
        l5 = (LinearLayout) getView().findViewById(R.id.layout5);
        l6 = (LinearLayout) getView().findViewById(R.id.layout6);
        l7 = (LinearLayout) getView().findViewById(R.id.layout7);
        tv = (TextView) getView().findViewById(R.id.tv);
        tv.setSelected(true);
        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);
        l5.setOnClickListener(this);
        l6.setOnClickListener(this);
        l7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout1:
                toChooseBall(2);

                break;
            case R.id.layout2:

                toChooseBall(7);
                break;
            case R.id.layout3:

                toChooseBall(1);
                break;
            case R.id.layout4:

                toChooseBall(3);
                break;
            case R.id.layout5:
                toChooseBall(8);
                break;
            case R.id.layout6:

                toChooseBall(4);
                break;
            case R.id.layout7:

                toChooseBall(5);
                break;


        }
    }

    private void toChooseBall(int mChooseType) {
        Intent intent = new Intent(getContext(), ChooseBallActivity.class);
        intent.putExtra(Constants.MCHOOSETYPE, mChooseType);
        startActivity(intent);
    }
}
