package com.mrice.txl.appthree.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.adapter.FOneAdapter;
import com.mrice.txl.appthree.ui.RebackActivity;
import com.mrice.txl.appthree.view.webview.WebViewActivity;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class OneFragment extends Fragment implements View.OnClickListener{

    private ListView lv;
    private FOneAdapter adapter;
    private List<PageOne> data;
    private LinearLayout dlt,ssq,qxc,qlc;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.f_one, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv = (ListView) getView().findViewById(R.id.lv);
        View head = LayoutInflater.from(getActivity()).inflate(R.layout.layout_banner, null);
        List<String> urls = new ArrayList<String>();
        urls.add("file:///android_asset/p.png");
        urls.add("file:///android_asset/h1.jpg");
        urls.add("file:///android_asset/h2.jpg");
        urls.add("file:///android_asset/h3.jpg");
        final List<String> paths = new ArrayList<>();
        paths.add("file:///android_asset/h0.html");
        paths.add("file:///android_asset/h1.html");
        paths.add("file:///android_asset/h2.html");
        paths.add("file:///android_asset/h3.html");
        Banner banner = (Banner) head.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(urls);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                WebViewActivity.loadUrl(getContext(), paths.get(position), "");
            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        View head1 = LayoutInflater.from(getActivity()).inflate(R.layout.layout_middle, null);
        dlt=(LinearLayout) head1.findViewById(R.id.layout1);
        ssq=(LinearLayout) head1.findViewById(R.id.layout2);
        qlc=(LinearLayout) head1.findViewById(R.id.layout3);
        qxc=(LinearLayout) head1.findViewById(R.id.layout4);
        dlt.setOnClickListener(this);
        ssq.setOnClickListener(this);
        qlc.setOnClickListener(this);
        qxc.setOnClickListener(this);
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.item_bottom, null);
        lv.addHeaderView(head);
        lv.addHeaderView(head1);
        lv.addFooterView(v);
        data = createData();
        adapter = new FOneAdapter(getActivity(), data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != data.size() + 2 && i != 0 && i != 1) {
                    WebViewActivity.loadUrl(getContext(), data.get(i - 2).getContent(), data.get(i - 2).getTitle());
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(getActivity(), RebackActivity.class);
        switch (view.getId()){
            case R.id.layout1:
                i.putExtra("type",1);
                break;
            case R.id.layout2:
                i.putExtra("type",2);
                break;
            case R.id.layout3:
                i.putExtra("type",3);
                break;
            case R.id.layout4:
                i.putExtra("type",4);
                break;
        }
        startActivity(i);
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

    private List<PageOne> createData() {

        List<PageOne> data = new ArrayList<PageOne>();
        PageOne p1 = new PageOne();
        p1.setTitle("一触即发 胜平负'单固'7天猜10场");
        p1.setTime("2017-10-11 09:45:12");
        p1.setContent("file:///android_asset/page1.html");
        PageOne p2 = new PageOne();
        p2.setTitle("北京彩站晒红单 “猜球者”出手现194倍高回报");
        p2.setTime("2017-10-09 15:33:25");
        p2.setContent("file:///android_asset/page2.html");
        PageOne p3 = new PageOne();
        p3.setTitle("竞彩品牌欢歌不断 “魅力竞彩”活动定位兰州");
        p3.setTime("2017-10-05 17:34:21");
        p3.setContent("file:///android_asset/page3.html");
        PageOne p4 = new PageOne();
        p4.setTitle("“魅力竞彩·快乐同行”系列活动相约洛阳");
        p4.setTime("2017-10-04 16:02:33");
        p4.setContent("file:///android_asset/page4.html");
        PageOne p5 = new PageOne();
        p5.setTitle("上海上港出征亚冠 胜平负“单固”豪强云集");
        p5.setTime("2017-10-03 13:21:22");
        p5.setContent("file:///android_asset/page5.html");
        PageOne p6 = new PageOne();
        p6.setTitle("湖南长沙业主合力出票 彩民喜中竞彩篮球340万");
        p6.setTime("2017-10-02 10:11:21");
        p6.setContent("file:///android_asset/page6.html");
        PageOne p7 = new PageOne();
        p7.setTitle("湖北“竞彩篮球嘉年华”9999元创业金等你拿");
        p7.setTime("2017-10-02 09:02:00");
        p7.setContent("file:///android_asset/page7.html");
        PageOne p8 = new PageOne();
        p8.setTitle("提升销量从竞彩入手 业主用坚持换彩民认可");
        p8.setTime("2017-10-01 17:22:02");
        p8.setContent("file:///android_asset/page8.html");
        PageOne p9 = new PageOne();
        p9.setTitle("营口竞彩高手倍投“2串1” 中奖17万余元");
        p9.setTime("2017-10-01 08:32:11");
        p9.setContent("file:///android_asset/page9.html");
        PageOne p10 = new PageOne();
        p10.setTitle("《竞彩情报站》每周开播 共赏赛事一起竞彩");
        p10.setTime("2017-9-26 10:22:21");
        p10.setContent("file:///android_asset/page10.html");

        data.add(p1);
        data.add(p2);
        data.add(p3);
        data.add(p4);
        data.add(p5);
        data.add(p6);
        data.add(p7);
        data.add(p8);
        data.add(p9);
        data.add(p10);
        return data;
    }
}
