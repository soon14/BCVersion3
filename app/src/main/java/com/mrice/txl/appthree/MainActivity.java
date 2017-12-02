package com.mrice.txl.appthree;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mrice.txl.appthree.app.Constants;
import com.mrice.txl.appthree.databinding.ActivityMainBinding;
import com.mrice.txl.appthree.runtimepermissions.PermissionsManager;
import com.mrice.txl.appthree.runtimepermissions.PermissionsResultAction;
import com.mrice.txl.appthree.ui.UserFragment;
import com.mrice.txl.appthree.ui.UserFragment2;
import com.mrice.txl.appthree.ui.me.KJFragment2;
import com.mrice.txl.appthree.ui.me.OneFragment;
import com.mrice.txl.appthree.ui.me.TwoFragment;
import com.mrice.txl.appthree.ui.service.AwardFragment;
import com.mrice.txl.appthree.ui.service.ServiceFragment;
import com.mrice.txl.appthree.utils.SPUtils;
import com.mrice.txl.appthree.utils.ToastUtil;
import com.mrice.txl.appthree.view.MyFragmentPagerAdapter;

import java.util.ArrayList;


/**
 * Created by cai on 16/11/21.
 */
public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private long lastClickTime = 0;
    private Button[] mTabs;
    private UserFragment2 userFragment;
    private ServiceFragment serviceFragment;
    private KJFragment2 purchaseFragment;
    private AwardFragment awardFragment;
    private OneFragment purchaseFragmentOne;
    private BeijingFragment beijingFragment;
    private Fragment[] fragments;
    private int index;
    private int currentTabIndex;

    // 一定需要对应的bean
    private ActivityMainBinding mBinding;
    private ViewPager vpContent;

    /**
     * 底部按钮
     */
    private Button btnPurchase, btnUser, btnService;

    /**
     * 标题
     */
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        initView();

        requestPermissions();

        initContentFragments();

    }

    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
//				Toast.makeText(MainActivity.this, "All permissions have been granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDenied(String permission) {
                //Toast.makeText(MainActivity.this, "Permission " + permission + " has been denied", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initContentFragments() {
        userFragment = new UserFragment2();
        serviceFragment = new ServiceFragment();
        purchaseFragment = new KJFragment2();
        purchaseFragmentOne = new OneFragment();
//        awardFragment = new AwardFragment();
//        beijingFragment = new BeijingFragment();
        fragments = new Fragment[]{purchaseFragmentOne, purchaseFragment, userFragment};
        ArrayList<Fragment> mFragmentList = new ArrayList<>();
        for (Fragment fragment : fragments) {
            mFragmentList.add(fragment);
        }
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        vpContent.setAdapter(adapter);
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        vpContent.setOffscreenPageLimit(2);
        vpContent.addOnPageChangeListener(this);
        vpContent.setCurrentItem(0);
    }

    private void initView() {
        vpContent = mBinding.vpContent;
        btnPurchase = mBinding.btnPurchase;
        btnUser = mBinding.btnUser;
        btnService = mBinding.btnService;
        title = mBinding.titleBar.titlebarTitle;

        mTabs = new Button[3];
        mTabs[0] = (Button) findViewById(R.id.btn_purchase);
        mTabs[1] = (Button) findViewById(R.id.btn_service);
        mTabs[2] = (Button) findViewById(R.id.btn_user);
        // select first tab
        mTabs[0].setSelected(true);

        title.setText(R.string.fragment_purchase_title);

//        SPUtils.putBoolean(Constants.IS_LOGIN, true);
        SPUtils.putBoolean(Constants.IS_SPLASH, true);

    }

    /**
     * on tab clicked
     *
     * @param view
     */
    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_purchase:
                index = 0;
                if (vpContent.getCurrentItem() != 0) {//不然cpu会有损耗
                    btnPurchase.setSelected(true);
                    btnUser.setSelected(false);
                    btnService.setSelected(false);
                    vpContent.setCurrentItem(0);
                }
                break;
            case R.id.btn_service:
                index = 1;
                if (vpContent.getCurrentItem() != 1) {//不然cpu会有损耗
                    btnPurchase.setSelected(false);
                    btnUser.setSelected(false);
                    btnService.setSelected(true);
                    vpContent.setCurrentItem(1);
                }
                break;
            case R.id.btn_user:
                if (vpContent.getCurrentItem() != 2) {//不然cpu会有损耗
                    btnPurchase.setSelected(false);
                    btnUser.setSelected(true);
                    btnService.setSelected(false);
                    vpContent.setCurrentItem(2);
                }
                index = 2;
                break;
        }
//        if (currentTabIndex != index) {
//            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
//            trx.hide(fragments[currentTabIndex]);
//            if (!fragments[index].isAdded()) {
//                trx.add(R.id.fragment_container, fragments[index]);
//            }
//            trx.show(fragments[index]).commit();
//        }
//        mTabs[currentTabIndex].setSelected(false);
//        // set current tab selected
//        mTabs[index].setSelected(true);
//        currentTabIndex = index;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        if (lastClickTime == 0) {
            lastClickTime = System.currentTimeMillis();
            ToastUtil.showToast(getString(R.string.login_out));
            return;
        }

        final long interval = System.currentTimeMillis() - lastClickTime;

        lastClickTime = System.currentTimeMillis();

        if (interval > 2000) {
            ToastUtil.showToast(getString(R.string.login_out));
        } else {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                title.setText(getString(R.string.fragment_purchase_title));
                btnPurchase.setSelected(true);
                btnService.setSelected(false);
                btnUser.setSelected(false);
                break;
            case 1:
                title.setText(getString(R.string.fragment_discover_title));
                btnPurchase.setSelected(false);
                btnService.setSelected(true);
                btnUser.setSelected(false);
                break;
            case 2:
                title.setText(getString(R.string.fragment_user_title));
                btnPurchase.setSelected(false);
                btnService.setSelected(false);
                btnUser.setSelected(true);
                break;
        }


    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
