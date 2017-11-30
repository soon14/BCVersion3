package com.mrice.txl.appthree.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.databinding.FragmentHomeBinding;

/**
 * Created by company on 2017/8/2.
 */

public class HomeFragment extends BaseFragment<FragmentHomeBinding> implements ViewPager.OnPageChangeListener{

    private String[] mTitles=new String[]{"福利彩票","体育彩票"};
    private HomeViewpagerAdapter homeViewpagerAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        initView();
    }

    private void initView(){
        homeViewpagerAdapter = new HomeViewpagerAdapter(getChildFragmentManager(), mTitles);
        bindingView.viewpager.setAdapter(homeViewpagerAdapter);
        // 设置ViewPager最大缓存的页面个数
        bindingView.viewpager.setOffscreenPageLimit(4);
        // 给ViewPager添加页面动态监听器（为了让Toolbar中的Title可以变化相应的Tab的标题）
        bindingView.viewpager.addOnPageChangeListener(this);

        bindingView.tablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        bindingView.tablayout.setTabMode(TabLayout.MODE_FIXED);
        bindingView.tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorTheme));
        bindingView.tablayout.setTabTextColors(getResources().getColor(R.color.black),getResources().getColor(R.color.colorTheme));
        // 将TabLayout和ViewPager进行关联，让两者联动起来
        bindingView.tablayout.setupWithViewPager(bindingView.viewpager);
        // 设置Tablayout的Tab显示ViewPager的适配器中的getPageTitle函数获取到的标题
        bindingView.tablayout.setTabsFromPagerAdapter(homeViewpagerAdapter);
        bindingView.viewpager.setOffscreenPageLimit(5);
    }

    @Override
    public int setContent() {
        return R.layout.fragment_home;
    }

    public class HomeViewpagerAdapter  extends FragmentStatePagerAdapter {

        private String[] mTitles;
        //private List<Fragment> mFragments;

        public HomeViewpagerAdapter(FragmentManager fm, String[] mTitles) {
            super(fm);
            this.mTitles = mTitles;
            // this.mFragments = mFragments;
        }

        @Override public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override public Fragment getItem(int position) {

            return HomeDetailFragment.newInstance(position,mTitles[position]);
        }

        @Override public int getCount() {
            return mTitles.length;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
