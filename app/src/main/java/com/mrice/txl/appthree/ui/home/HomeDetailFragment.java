package com.mrice.txl.appthree.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.HomeAdapter;
import com.mrice.txl.appthree.base.BaseFragment;
import com.mrice.txl.appthree.bean.MultipleItem;
import com.mrice.txl.appthree.databinding.FragmentHomeDetailsBinding;
import com.mrice.txl.appthree.ui.me.KJDetailsActivity;
import com.mrice.txl.appthree.ui.me.OneFragment;
import com.mrice.txl.appthree.view.webview.WebViewActivity;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by app on 2017/11/29.
 */
public class HomeDetailFragment extends BaseFragment<FragmentHomeDetailsBinding> {

    private int position;
    private List<MultipleItem> datas;
    private HomeAdapter adapter;

    public static HomeDetailFragment newInstance(int position, String title) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putInt("position", position);
        HomeDetailFragment fragment = new HomeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showContentView();
        Bundle args = getArguments();
        if (args != null) {
            position = args.getInt("position");
        }
        initView(position);
    }

    @Override
    public int setContent() {
        return R.layout.fragment_home_details;
    }


    private void initView(int p) {

        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_banner, null);
        List<String> urls = new ArrayList<String>();
        final List<String> paths = new ArrayList<>();
        switch (p) {
            case 0:
                urls.add("file:///android_asset/pt1_1.jpg");
                urls.add("file:///android_asset/pt1_2.jpg");
                urls.add("file:///android_asset/pt1_3.jpg");
                paths.add("file:///android_asset/pt1_1.html");
                paths.add("file:///android_asset/pt1_2.html");
                paths.add("file:///android_asset/pt1_3.html");
                break;

            case 1:
                urls.add("file:///android_asset/p.png");
                urls.add("file:///android_asset/h1.jpg");
                urls.add("file:///android_asset/h2.jpg");
                urls.add("file:///android_asset/h3.jpg");

                paths.add("file:///android_asset/h0.html");
                paths.add("file:///android_asset/h1.html");
                paths.add("file:///android_asset/h2.html");
                paths.add("file:///android_asset/h3.html");
                break;
            case 2:
                break;
        }


        Banner banner = (Banner) headerView.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(urls);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                WebViewActivity.loadUrl(getContext(), paths.get(position), "最新资讯");
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        datas = PubData.getHomeData(p);
        adapter = new HomeAdapter(datas);
        adapter.addHeaderView(headerView);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        bindingView.rlv.setLayoutManager(layoutManager);
        bindingView.rlv.setAdapter(adapter);
        //条目点击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (datas.get(position).getItemType() == MultipleItem.MUKUAI) {
                    Intent i = new Intent(getActivity(), KJDetailsActivity.class);
                    if ("双色球".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 1);
                    } else if ("七乐彩".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 2);
                    } else if ("大乐透".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 3);
                    } else if ("排列三".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 5);
                    } else if ("排列五".equals(datas.get(position).getTitle())) {
                        i.putExtra("position", 6);
                    }
                    startActivity(i);
                } else if (datas.get(position).getItemType() == MultipleItem.XINWEN) {
                    WebViewActivity.loadUrl(getContext(), datas.get(position).getContent(), "近期彩讯");
                }
            }
        });
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            //Glide 加载图片简单用法
            Glide.with(context).load(path).into(imageView);

//            //用fresco加载图片简单用法，记得要写下面的createImageView方法
//            Uri uri = Uri.parse((String) path);
//            imageView.setImageURI(uri);
        }
    }
}
