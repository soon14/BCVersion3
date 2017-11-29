package com.mrice.txl.appthree;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.databinding.ActivityUpdatenameBinding;
import com.mrice.txl.appthree.utils.ToastUtil;

/**
 * Created by cai on 2017/8/26.
 */

public class UpdateNameActivity extends BaseActivity<ActivityUpdatenameBinding> {
    private String nickName;
    private boolean isFromNick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatename);
        showContentView();
        if (getIntent() != null) {
            isFromNick = getIntent().getBooleanExtra(Constants.TYPE, true);
        }
        setTitle(isFromNick ? "修改昵称" : "修改个性签名");
        bindingView.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputValid()) {
                    Intent intent = new Intent();
                    if (isFromNick)
                        intent.putExtra(Constants.NICK_NAME, nickName);
                    else
                        intent.putExtra(Constants.NICK_DES, nickName);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private boolean isInputValid() {
        nickName = bindingView.nameInput.getText().toString();
        if (TextUtils.isEmpty(nickName)) {
            ToastUtil.showToast(isFromNick ? "请输入昵称" : "请输入个性签名");
            return false;
        }
        if (nickName.length() < 3) {
            ToastUtil.showToast(isFromNick ? "昵称不能少于3个字" : "个性签名不能少于3个字");
            return false;
        }
        return true;
    }
}
