package com.mrice.txl.appthree.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.StarActivity;
import com.mrice.txl.appthree.VersionActivity;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.app.IntentValue;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.bean.LoginResponse;
import com.mrice.txl.appthree.databinding.FragmentUserBinding;
import com.mrice.txl.appthree.http.cache.ACache;
import com.mrice.txl.appthree.ui.login.LoginActivity;
import com.mrice.txl.appthree.ui.menu.NavIntroductionActivity;
import com.mrice.txl.appthree.utils.DialogFactory;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.utils.ShareUtils;
import com.mrice.txl.appthree.view.webview.WebViewActivity;

import static android.app.Activity.RESULT_OK;

/**
 * Created by cai on 2017/8/2.
 */

public class UserFragment extends BaseFragment<FragmentUserBinding> {

    private TextView share, loginOut, updatePassword, introduction, problem;
    private ImageView iv_avator;
    private ACache mAcache;
    float arr[] = {0.2f, 1.2f, 0.6f, 0.3f, 0.5f, 0.8f};//定义一个数组
    private boolean clear = false;
    boolean isLogin = false;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showContentView();

        initView();

        loadUserData();


    }

    private void loadUserData() {
        mAcache = ACache.get(getContext());
        LoginResponse.User user = (LoginResponse.User) mAcache.getAsObject(Constants.USER);
        isLogin = SPUtils.getBoolean(Constants.IS_LOGIN, false);
        if (isLogin && user != null) {
            bindingView.tvPhone.setText(user.getPhone() + "，" + "欢迎您");
            loginOut.setVisibility(View.VISIBLE);
        } else {
            loginOut.setVisibility(View.VISIBLE);
        }

    }

    private void initView() {
        share = bindingView.share;
        problem = bindingView.problem;
        introduction = bindingView.introduction;
        loginOut = bindingView.loginOut;
        updatePassword = bindingView.updatePassword;
        iv_avator = bindingView.ivAvatar;
        initListener();
    }

    private void initListener() {
        share.setOnClickListener(this);
        problem.setOnClickListener(this);
        introduction.setOnClickListener(this);
        loginOut.setOnClickListener(this);
        iv_avator.setOnClickListener(this);
        updatePassword.setOnClickListener(this);
        bindingView.shoucang.setOnClickListener(this);
        bindingView.tvPhone.setOnClickListener(this);
        bindingView.banben.setOnClickListener(this);
    }

    @Override
    protected void onViewClick(View view) {
        super.onViewClick(view);
        switch (view.getId()) {
            case R.id.share:
                ShareUtils.share(getContext(), R.string.string_share_text);
                break;
            case R.id.problem:
                WebViewActivity.loadUrl(getContext(), "file:///android_asset/wenda.html", "帮助");
                break;
            case R.id.loginOut:
                if(isLogin) {
                    loginOut();
                }
                break;
            case R.id.introduction:
                NavIntroductionActivity.startHome(getContext());
                break;
            case R.id.iv_avatar:
                break;
            case R.id.updatePassword:
                updatePwd();
                break;
            case R.id.tv_phone:
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivityForResult(intent, 22);
                break;
            case R.id.shoucang:
                Intent i = new Intent(getContext(), StarActivity.class);
                startActivity(i);
                break;
            case R.id.banben:
                Intent ii = new Intent(getContext(), VersionActivity.class);
                startActivity(ii);
                break;
        }
    }

    /**
     * 修改密码
     */

    private void updatePwd() {
        Intent intent = new Intent(getContext(), ModifyPwdActivity.class);
        intent.putExtra(IntentValue.from_where, "user");
        startActivity(intent);
    }

    /**
     * 登录流程
     */
    private void loginOut() {
        DialogFactory.createFullContentDialog((FragmentActivity) getContext(), "退出登录", "确定", "取消", "确定退出当前用户登录状态", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SPUtils.putBoolean(Constants.IS_LOGIN, false);
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivityForResult(intent, 22);
                mAcache.clear();
                bindingView.tvPhone.setText("未登录，点击登录");
                //loginOut.setVisibility(View.GONE);
                //getActivity().finish();
                dialogInterface.dismiss();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 22) {
                LoginResponse.User user = (LoginResponse.User) mAcache.getAsObject(Constants.USER);
                bindingView.tvPhone.setText(user.getPhone() + "，" + "欢迎您");
                loginOut.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public int setContent() {
        return R.layout.fragment_user;
    }
}
