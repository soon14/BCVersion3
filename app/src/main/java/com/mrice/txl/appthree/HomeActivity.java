package com.mrice.txl.appthree;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.mrice.txl.appthree.databinding.ActivityHomeBinding;
import com.mrice.txl.appthree.runtimepermissions.PermissionsManager;
import com.mrice.txl.appthree.runtimepermissions.PermissionsResultAction;

import com.mrice.txl.appthree.ui.UserFragment;
import com.mrice.txl.appthree.ui.home.HomeFragment;
import com.mrice.txl.appthree.ui.me.TwoFragment;
import com.mrice.txl.appthree.view.MyFragmentPagerAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private Fragment[] fragments;
    private HomeFragment homeFragment;
    private UserFragment userFragment;
    private TwoFragment purchaseFragment;
    // 一定需要对应的bean
    private ActivityHomeBinding mBinding;
    private ViewPager vpContent;
    /**
     * 标题
     */
    private TextView title;
    private Toolbar toolbar;
    private Button[] mTabs;
    private int index;
    private int currentTabIndex;

    /**
     * 底部按钮
     */
    private Button btnPurchase, btnUser, btnService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        initView();
        requestPermissions();
        initContentFragments();
    }

    private void initView() {
        toolbar = mBinding.appbarhome.toolbar;
        setSupportActionBar(toolbar);

        vpContent = mBinding.appbarhome.contentHome.vpContent;
        btnPurchase = mBinding.appbarhome.contentHome.btnPurchase;
        btnUser = mBinding.appbarhome.contentHome.btnUser;
        btnService = mBinding.appbarhome.contentHome.btnService;
//        title = mBinding.titleBar.titlebarTitle;

        mTabs = new Button[3];
        mTabs[0] = (Button) findViewById(R.id.btn_purchase);
        mTabs[1] = (Button) findViewById(R.id.btn_service);
        mTabs[2] = (Button) findViewById(R.id.btn_user);
        // select first tab
        mTabs[0].setSelected(true);

//        title.setText(R.string.fragment_purchase_title);

//        SPUtils.putBoolean(Constants.IS_LOGIN, true);
//        SPUtils.putBoolean(Constants.IS_SPLASH, true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
            }

            @Override
            public void onDenied(String permission) {
            }
        });
    }

    private void initContentFragments() {
        homeFragment = new HomeFragment();
        purchaseFragment = new TwoFragment();
        userFragment = new UserFragment();
        fragments = new Fragment[]{homeFragment, purchaseFragment, userFragment};
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
//                title.setText(getString(R.string.fragment_purchase_title));
                btnPurchase.setSelected(true);
                btnService.setSelected(false);
                btnUser.setSelected(false);
                break;
            case 1:
//                title.setText(getString(R.string.fragment_discover_title));
                btnPurchase.setSelected(false);
                btnService.setSelected(true);
                btnUser.setSelected(false);
                break;
            case 2:
//                title.setText(getString(R.string.fragment_user_title));
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