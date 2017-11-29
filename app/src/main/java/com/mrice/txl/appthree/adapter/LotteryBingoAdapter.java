package com.mrice.txl.appthree.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.baseadapter.BaseRecyclerViewAdapter;
import com.mrice.txl.appthree.base.baseadapter.BaseRecyclerViewHolder;
import com.mrice.txl.appthree.bean.NewsBean;
import com.mrice.txl.appthree.databinding.ItemPurchaseOne1Binding;
import com.mrice.txl.appthree.utils.ImgLoadUtil;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.mrice.txl.appthree.view.webview.WebViewActivity;

import java.util.List;

/**
 * Created by cai on 2016/12/27.
 */

public class LotteryBingoAdapter extends BaseRecyclerViewAdapter<List<NewsBean.Result.NewsData>> {

    private static final int TYPE_ONE = 2;// 一张图

    @Override
    public int getItemViewType(int position) {

        return TYPE_ONE;

    }


    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case TYPE_ONE:
                return new OneHolder(parent, R.layout.item_purchase_one1);

//            default:
//                return new ThreeHolder(parent, R.layout.item_purchase_three);
        }
        return null;
    }

    private class OneHolder extends BaseRecyclerViewHolder<List<NewsBean.Result.NewsData>, ItemPurchaseOne1Binding> {

        OneHolder(ViewGroup parent, int title) {
            super(parent, title);
        }

        @Override
        public void onBindViewHolder(final List<NewsBean.Result.NewsData> object, int position) {

            binding.tvAndroidTime.setText(object.get(position).getDate());
            setDes(object, position, binding.tvAndroidTitle);
            displayRandomImg(1, position, binding.ivAndroidPic, object);
//            }
            setOnClick(binding.llWelfareOther, object.get(position));
        }
    }

    private void setDes(List<NewsBean.Result.NewsData> object, int position, TextView textView) {
        textView.setText(object.get(position).getTitle());
    }

    private void displayRandomImg(int imgNumber, int position, ImageView imageView, List<NewsBean.Result.NewsData> object) {
//        DebugUtil.error("-----Image_url: "+object.get(position).getImage_url());
        ImgLoadUtil.displayRandom(imgNumber, object.get(position).getThumbnail_pic_s(), imageView);
    }


    private void setOnClick(final RelativeLayout linearLayout, final NewsBean.Result.NewsData bean) {
        linearLayout.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                WebViewActivity.loadUrl(v.getContext(), bean.getUrl(), bean.getTitle());
            }
        });

//        linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                View view = View.inflate(v.getContext(), R.layout.title_douban_top, null);
//                TextView titleTop = (TextView) view.findViewById(R.id.title_top);
//                titleTop.setTextSize(14);
//                String title = TextUtils.isEmpty(bean.getType()) ? bean.getDesc() : bean.getType() + "：  " + bean.getDesc();
//                titleTop.setText(title);
//                builder.setCustomTitle(view);
//                builder.setPositiveButton("查看详情", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        WebViewActivity.loadUrl(linearLayout.getContext(), bean.getUrl(), "加载中...");
//                    }
//                });
//                builder.show();
//                return false;
//            }
//        });

    }
}
