package com.mrice.txl.appthree.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrice.txl.appthree.R;

/**
 * Created by app on 2017/11/30.
 */
public class KJDetailsActivity extends AppCompatActivity {

    private int position = 1;
    private String title = "";
    private String time = "";
    private TextView txtTitle;
    private TextView txtTime;
    private ImageView img;
    private TextView b1, b2, b3, b4, b5, b6, b7;
    private TextView lm1, lm2, lm3, lm4, lm5, lm6, lm7, lm8, lm9;
    private TextView lr1, lr2, lr3, lr4, lr5, lr6, lr7, lr8, lr9;
    private LinearLayout layoutSSQ;
    private LinearLayout layoutPL3;
    private LinearLayout layoutPL5;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kjdetails);
        position = getIntent().getIntExtra("position", position);
        initTitle(position);
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
        txtTitle = (TextView) findViewById(R.id.title);
        txtTime = (TextView) findViewById(R.id.time);
        img = (ImageView) findViewById(R.id.img);
        txtTitle.setText(title);
        txtTime.setText(time);
        button = (Button) findViewById(R.id.checkHistory);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KJDetailsActivity.this, KJHistoryActivity.class);
                i.putExtra("position", position);
                i.putExtra("title", title);
                startActivity(i);
            }
        });
        layoutSSQ = (LinearLayout) findViewById(R.id.layout_ssq);
        layoutPL3 = (LinearLayout) findViewById(R.id.layout_pl3);
        layoutPL5 = (LinearLayout) findViewById(R.id.layout_pl5);
        b1 = (TextView) findViewById(R.id.b1);
        b2 = (TextView) findViewById(R.id.b2);
        b3 = (TextView) findViewById(R.id.b3);
        b4 = (TextView) findViewById(R.id.b4);
        b5 = (TextView) findViewById(R.id.b5);
        b6 = (TextView) findViewById(R.id.b6);
        b7 = (TextView) findViewById(R.id.b7);
        lm1 = (TextView) findViewById(R.id.line_m1);
        lm2 = (TextView) findViewById(R.id.line_m2);
        lm3 = (TextView) findViewById(R.id.line_m3);
        lm4 = (TextView) findViewById(R.id.line_m4);
        lm5 = (TextView) findViewById(R.id.line_m5);
        lm6 = (TextView) findViewById(R.id.line_m6);
        lm7 = (TextView) findViewById(R.id.line_m7);
        lm8 = (TextView) findViewById(R.id.line_m8);
        lm9 = (TextView) findViewById(R.id.line_m9);

        lr1 = (TextView) findViewById(R.id.line_r1);
        lr2 = (TextView) findViewById(R.id.line_r2);
        lr3 = (TextView) findViewById(R.id.line_r3);
        lr4 = (TextView) findViewById(R.id.line_r4);
        lr5 = (TextView) findViewById(R.id.line_r5);
        lr6 = (TextView) findViewById(R.id.line_r6);
        lr7 = (TextView) findViewById(R.id.line_r7);
        lr8 = (TextView) findViewById(R.id.line_r8);
        lr9 = (TextView) findViewById(R.id.line_r9);
        initBall(position);
    }

    private void initTitle(int p) {
        switch (p) {
            case 1:
                title = "双色球";
                time = "第2017140期";
                break;
            case 2:
                title = "七乐彩";
                time = "第2017140期";
                break;
            case 3:
                title = "大乐透";
                time = "第2017140期";
                break;
            case 4:
                title = "七星彩";
                time = "第2017140期";
                break;
            case 5:
                title = "排列三";
                time = "第17326期";
                break;
            case 6:
                title = "排列五";
                time = "第17326期";
                break;
            case 7:
                title = "快三";
                time = "第2017113074期";
                break;
            case 8:
                title = "11选5";
                time = "第2017113073期";
                break;
        }
    }

    private void initBall(int p) {
        switch (p) {
            case 1:
                img.setImageResource(R.drawable.lottery_icon_ssq);
                b7.setBackgroundResource(R.drawable.comm_ball_blue);
                layoutPL5.setVisibility(View.GONE);
                layoutPL3.setVisibility(View.GONE);
                b1.setText("21");
                b2.setText("22");
                b3.setText("25");
                b4.setText("28");
                b5.setText("29");
                b6.setText("30");
                b7.setText("08");
                lm1.setText("16");
                lm2.setText("83");
                lm3.setText("1431");
                lm4.setText("71547");
                lm5.setText("1461958");
                lm6.setText("13696628");
                lr1.setText("6035870");
                lr2.setText("249607");
                lr3.setText("3000");
                lr4.setText("200");
                lr5.setText("10");
                lr6.setText("5");
                break;
            case 2:
                img.setImageResource(R.drawable.lottery_icon_qlc);
                layoutPL5.setVisibility(View.GONE);
                layoutPL3.setVisibility(View.GONE);
                b1.setText("01");
                b2.setText("13");
                b3.setText("20");
                b4.setText("23");
                b5.setText("25");
                b6.setText("26");
                b7.setText("28");
                lm1.setText("1");
                lm2.setText("5");
                lm3.setText("134");
                lm4.setText("513");
                lm5.setText("4698");
                lm6.setText("9685");
                lr1.setText("1494577");
                lr2.setText("42702");
                lr3.setText("3186");
                lr4.setText("200");
                lr5.setText("50");
                lr6.setText("10");
                break;
            case 3:
                img.setImageResource(R.drawable.lottery_icon_lotto);
                b6.setBackgroundResource(R.drawable.comm_ball_blue);
                b7.setBackgroundResource(R.drawable.comm_ball_blue);
                layoutPL5.setVisibility(View.GONE);
                layoutPL3.setVisibility(View.GONE);
                b1.setText("10");
                b2.setText("16");
                b3.setText("25");
                b4.setText("26");
                b5.setText("29");
                b6.setText("01");
                b7.setText("05");
                lm1.setText("2");
                lm2.setText("85");
                lm3.setText("921");
                lm4.setText("35712");
                lm5.setText("650970");
                lm6.setText("6228673");
                lr1.setText("10000000");
                lr2.setText("91355");
                lr3.setText("3439");
                lr4.setText("200");
                lr5.setText("10");
                lr6.setText("5");
                break;
            case 4:
                img.setImageResource(R.drawable.lottery_icon_qxc);
                layoutPL5.setVisibility(View.GONE);
                layoutPL3.setVisibility(View.GONE);
                b1.setText("0");
                b2.setText("6");
                b3.setText("9");
                b4.setText("1");
                b5.setText("1");
                b6.setText("0");
                b7.setText("7");
                lm1.setText("0");
                lm2.setText("0");
                lm3.setText("0");
                lm4.setText("0");
                lm5.setText("0");
                lm6.setText("0");
                lr1.setText("0");
                lr2.setText("0");
                lr3.setText("1800");
                lr4.setText("300");
                lr5.setText("20");
                lr6.setText("5");
                break;
            case 5:
                img.setImageResource(R.drawable.lottery_icon_pl3);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                layoutSSQ.setVisibility(View.GONE);
                b1.setText("7");
                b2.setText("2");
                b3.setText("3");
                lm7.setText("6759");
                lm8.setText("0");
                lm9.setText("16645");
                lr7.setText("1040");
                lr8.setText("346");
                lr9.setText("173");
                break;
            case 6:
                img.setImageResource(R.drawable.lottery_icon_pl5);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                layoutSSQ.setVisibility(View.GONE);
                layoutPL3.setVisibility(View.GONE);
                b1.setText("7");
                b2.setText("2");
                b3.setText("3");
                b4.setText("1");
                b5.setText("4");
                lm7.setText("52");
                lr7.setText("100000");
                break;
            case 7:
                img.setImageResource(R.drawable.lottery_icon_k3);
                b4.setVisibility(View.GONE);
                b5.setVisibility(View.GONE);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                layoutSSQ.setVisibility(View.GONE);
                layoutPL3.setVisibility(View.GONE);
                b1.setText("3");
                b2.setText("3");
                b3.setText("4");
                lm7.setText("--");
                lr7.setText("--");
                break;
            case 8:
                img.setImageResource(R.drawable.lottery_icon_hongyun_11x5);
                b6.setVisibility(View.GONE);
                b7.setVisibility(View.GONE);
                layoutSSQ.setVisibility(View.GONE);
                layoutPL3.setVisibility(View.GONE);
                b1.setText("11");
                b2.setText("06");
                b3.setText("04");
                b4.setText("01");
                b5.setText("09");
                lm7.setText("--");
                lr7.setText("--");
                break;
        }

    }
}
