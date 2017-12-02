package com.mrice.txl.appthree.ui.me;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.DialogInterface;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.utils.DialogFactory;

import java.util.List;

/**
 * Created by Mr on 2017/12/2.
 */

public class YJFKActivity extends AppCompatActivity {

    private EditText txt;
    private Button btnCommit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yjfk);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("意见反馈");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txt=(EditText) findViewById(R.id.txt);
        btnCommit=(Button) findViewById(R.id.commit);
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=txt.getText().toString();
                if(TextUtils.isEmpty(str)){
                    Toast.makeText(getApplicationContext(),"请填写您的意见哦！",Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    AlertDialog.Builder builder=new AlertDialog.Builder(YJFKActivity.this);
                    builder.setMessage("我们已收到您的反馈，感谢您的建议").setPositiveButton("确 定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            dialogInterface.dismiss();
                        }
                    }).create().show();
                }
            }
        });
    }

}

