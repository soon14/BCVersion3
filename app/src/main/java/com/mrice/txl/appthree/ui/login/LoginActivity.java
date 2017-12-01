package com.mrice.txl.appthree.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.app.IntentValue;
import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.bean.LoginResponse;
import com.mrice.txl.appthree.bean.User;
import com.mrice.txl.appthree.databinding.ActivityLoginBinding;
import com.mrice.txl.appthree.http.RetrofitHttpClient;
import com.mrice.txl.appthree.http.cache.ACache;
import com.mrice.txl.appthree.ui.ModifyPwdActivity;
import com.mrice.txl.appthree.ui.register.RegisterActivity;
import com.mrice.txl.appthree.utils.PhoneNumberUtil;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.utils.StringUtil;
import com.mrice.txl.appthree.utils.ToastUtil;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cai on 2017/8/2.
 */

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    private static final String TAG = "LoginActivity";
    private Button loginButton;
    private EditText phoneEdit, passwordEdit;
    private TextView findPass, register;
    private String mUserName, mPassWord;
    private User user;
    private ACache mACache;
    private boolean isIn;
    private int STARTCODE_REGISTER = 100;
    private int STARTCODE_MODIFY = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        showContentView();

        initView();

        initData();
    }

    private void initData() {

        setTitle("登录");
        setBackAction(false);
        user = new User();
        mACache = ACache.get(this);
    }

    private void initView() {
        loginButton = bindingView.login;
        phoneEdit = bindingView.phoneEdit;
        passwordEdit = bindingView.passwordEdit;
        findPass = bindingView.findpass;
        register = bindingView.register;


        register.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        findPass.setOnClickListener(this);
    }

    /**
     * 效验数据合法性
     */
    private boolean isInputVaild() {
        mUserName = phoneEdit.getText().toString().trim();
        mPassWord = passwordEdit.getText().toString().trim();
        user.setData(mUserName, mPassWord);
        if (StringUtil.isEmpty(mUserName)) {
            ToastUtil.showToast(getString(R.string.input_your_number));
            return false;
        }

        if (!PhoneNumberUtil.checkPhoneNumber(mUserName)) {
            ToastUtil.showToast(getString(R.string.number_input_error));
            return false;
        }

        if (StringUtil.isEmpty(mPassWord)) {
            ToastUtil.showToast(getString(R.string.input_your_password));
            return false;
        }

        int len = mPassWord.length();
        if (len < 6 || len > 15) {
            ToastUtil.showToast(getString(R.string.input_your_password_error));
            return false;
        }

        return true;
    }


    @Override
    protected void onViewClick(View view) {
        super.onViewClick(view);
        switch (view.getId()) {
            case R.id.register:
                toRegisterActivity();
                break;
            case R.id.login:
                if (isInputVaild()) {
                    loginStep();
                }
                break;
            case R.id.findpass:
                toModifyPwd();
                break;
        }
    }

    private void toModifyPwd() {
        Intent intent = new Intent(this, ModifyPwdActivity.class);
        intent.putExtra(IntentValue.from_where, "login");
        startActivityForResult(intent, STARTCODE_REGISTER);
    }

    private void loginStep() {
        showProgressDialog();
        user.setData(mUserName, mPassWord);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(user));
        Subscription subscribe = RetrofitHttpClient.Builder.getYunServer().login(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                        hideProgressDialog();
                        ToastUtil.showToast(getString(R.string.network_disable));
                    }

                    @Override
                    public void onNext(LoginResponse response) {
                        hideProgressDialog();
                        if (response.isRequestSuccess()) {
                            //请求成功，进入登录逻辑
                            mACache.put(Constants.USER, response.getUser());
                            SPUtils.putBoolean(Constants.IS_LOGIN, true);
                            toMainActivity();
                        } else {
                            ToastUtil.showToast("用户名或密码错误");
                        }
                    }
                });
        addSubscription(subscribe);
    }

    /**
     * 去注册
     */
    private void toRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, STARTCODE_REGISTER);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            phoneEdit.setText(data.hasExtra(IntentValue.phone) ? data.getStringExtra(IntentValue.phone) : "");
//                passwordEdit.setText(data.hasExtra(IntentValue.password) ? data.getStringExtra(IntentValue.password) : "");
        }
    }

    private void toMainActivity() {
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
//        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
        setResult(RESULT_OK);
        finish();
        isIn = true;
    }
}
