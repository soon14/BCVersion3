package com.mrice.txl.appthree.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.app.IntentValue;
import com.mrice.txl.appthree.base.BaseActivity;
import com.mrice.txl.appthree.bean.LoginResponse;
import com.mrice.txl.appthree.databinding.ActivityRegisterBinding;
import com.mrice.txl.appthree.http.RetrofitHttpClient;
import com.mrice.txl.appthree.http.cache.ACache;
import com.mrice.txl.appthree.ui.login.LoginActivity;
import com.mrice.txl.appthree.utils.CommonUtils;
import com.mrice.txl.appthree.utils.PhoneNumberUtil;
import com.mrice.txl.appthree.utils.StringUtil;
import com.mrice.txl.appthree.utils.ToastUtil;
import com.mrice.txl.appthree.view.CountdownInputBoxView;
import com.google.gson.Gson;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cai on 2017/8/4.
 */

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {
    private static final String TAG = "RegisterActivity";
    private CountdownInputBoxView mCountDownInputBoxView;
    private EditText phoneEdit, passwordEdit, usernameEdit;
    private Button registerButton;
    /**
     * 是否点击了验证码
     */
    private boolean isClickVerify = false;
    private String mNumber;
    private String mPassword;
    private String mUserName;
    private String smsCode;

    private ACache mAcache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        setTitle("注册");
        showContentView();

        initView();

        mAcache = ACache.get(this);
    }

    private void initView() {
        mCountDownInputBoxView = bindingView.countdownInputbox;
        registerButton = bindingView.register;
        phoneEdit = bindingView.phoneEdit;
        passwordEdit = bindingView.passwordEdit;
        usernameEdit = bindingView.usernameEdit;

        registerButton.setOnClickListener(this);

        mCountDownInputBoxView = (CountdownInputBoxView) findViewById(R.id.countdown_inputbox);


        mCountDownInputBoxView.setTitle(getResources().getString(R.string.verifyCode));
        mCountDownInputBoxView.setEditLength(6);
        mCountDownInputBoxView.setEditInputType(InputType.TYPE_CLASS_NUMBER);
        mCountDownInputBoxView.setGetVerifyCodeListener(this);
        mCountDownInputBoxView.getVerfyCodeButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取验证码
                isClickVerify = true;
                getSmsCode();
            }
        });
    }

    /**
     * 获取验证码
     * http://localhost:80/yxsm_api/login/getValidMM
     */
    private void getSmsCode() {
        if (isInputVaild(isClickVerify)) {
            showProgressDialog();
            isClickVerify = false;
            mCountDownInputBoxView.startCountdown();
            final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), CommonUtils.getRequestParams("phone", mNumber));
            Subscription subscribe = RetrofitHttpClient.Builder.getYunServer().getVerifyCode(requestBody)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted: ");
                            hideProgressDialog();
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
                            } else if (response.isRequestSituation()) {
                                mCountDownInputBoxView.cancleTime();
                                ToastUtil.showToast(getString(R.string.verifycode_failed));
                            } else {
                                mCountDownInputBoxView.cancleTime();
                                ToastUtil.showToast(getString(R.string.verifycode_repeat));
                            }
                        }
                    });
            addSubscription(subscribe);
        }
    }

    /**
     * 效验数据合法性
     */


    private boolean isInputVaild(boolean verifyFlag) {
        mUserName = usernameEdit.getText().toString().trim();
        mNumber = phoneEdit.getText().toString().trim();
        mPassword = passwordEdit.getText().toString().trim();
        smsCode = mCountDownInputBoxView.getVerifycodeEdit().getText().toString().trim();
        if (StringUtil.isEmpty(mNumber)) {
            ToastUtil.showToast(getString(R.string.input_your_number));
            return false;
        }

        if (!PhoneNumberUtil.checkPhoneNumber(mNumber)) {
            ToastUtil.showToast(getString(R.string.number_input_error));
            return false;
        }
        if (!verifyFlag) {
            if (TextUtils.isEmpty(mUserName)) {
                ToastUtil.showToast(getString(R.string.input_username));
                return false;
            }
            if (!CommonUtils.checkUsername(mUserName)) {
                ToastUtil.showToast(getString(R.string.username_rule));
                return false;
            }
            if (StringUtil.isEmpty(mPassword)) {
                ToastUtil.showToast(getString(R.string.input_your_password));
                return false;
            }

            int len = mPassword.length();
            if (len < 6 || len > 15) {
                ToastUtil.showToast(getString(R.string.input_your_password_error));
                return false;
            }
            if (StringUtil.isEmpty(smsCode)) {
                ToastUtil.showToast(getString(R.string.input_verifycode));
                return false;
            }

            if (smsCode.length() != 6) {
                ToastUtil.showToast(getString(R.string.input_correct_verifycode));
                return false;
            }
        }
        return true;
    }

    /**
     * http://localhost/yxsm_api/login/register
     * 注册
     * {
     * "phone":"18901234567",
     * "password":"123456",
     * "name":"123456"
     * }
     */
    @Override
    protected void onViewClick(View view) {
        super.onViewClick(view);
        switch (view.getId()) {
            case R.id.register:
                if (isInputVaild(isClickVerify)) {
                    //转到登录界面
                    showProgressDialog();
                    HashMap map = new HashMap();
                    map.put("name", smsCode);
                    map.put("phone", mNumber);
                    map.put("password", mPassword);
                    RequestBody requestBody = getRequestBody(new Gson().toJson(map));
                    Subscription subscription = RetrofitHttpClient.Builder.getYunServer().register(requestBody)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<LoginResponse>() {
                                           @Override
                                           public void onCompleted() {

                                           }

                                           @Override
                                           public void onError(Throwable e) {
                                               hideProgressDialog();
                                               ToastUtil.showToast(e.getMessage());
                                           }

                                           @Override
                                           public void onNext(LoginResponse response) {
                                               hideProgressDialog();
                                               if (response.isRequestSuccess()) {
                                                   LoginResponse.User user = response.getUser();
                                                   if(user!=null){
                                                       mAcache.put(Constants.USER, user);
                                                   }
                                                   ToastUtil.showToast("注册成功");
                                                   toLoginStep();
                                               } else if (response.isRequestFailed()) {
                                                   ToastUtil.showToast(getString(R.string.input_correct_verifycode));
                                               } else {
                                                   ToastUtil.showToast("您的手机号已注册，请更换后重新尝试");
                                               }
                                           }
                                       }
                            );
                    addSubscription(subscription);
                }
                break;
        }
    }

    /**
     * m,≤
     * 跳转登录
     */
    private void toLoginStep() {
        LoginResponse.User user = (LoginResponse.User) mAcache.getAsObject(Constants.USER);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(IntentValue.phone, user.getPhone());
        intent.putExtra(IntentValue.password, user.getPassword());
        setResult(RESULT_OK, intent);
        finish();
    }
}
