package com.mrice.txl.appthree.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.bean.MultipleItem;

import java.util.List;

/**
 * Created by app on 2017/11/30.
 */
public class HomeAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    public HomeAdapter(List data) {
        super(data);
        addItemType(MultipleItem.BANNER, R.layout.home_item1);
        addItemType(MultipleItem.MUKUAI, R.layout.home_item2);
        addItemType(MultipleItem.XINWEN, R.layout.f_one_item);
        addItemType(MultipleItem.MUKUAI2, R.layout.home_item3);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, MultipleItem multipleItem) {
        switch (baseViewHolder.getItemViewType()) {
            case MultipleItem.BANNER:
                Glide.with(mContext).load(multipleItem.getUrl()).crossFade().into((ImageView) baseViewHolder.getView(R.id.bannerUrl));
                break;
            case MultipleItem.MUKUAI:
                baseViewHolder.setText(R.id.title, multipleItem.getTitle())
                        .setText(R.id.time, multipleItem.getPubTime());
                String[] balls = multipleItem.getContent().split(",");
                baseViewHolder.setText(R.id.b1, balls[0]);
                baseViewHolder.setText(R.id.b2, balls[1]);
                baseViewHolder.setText(R.id.b3, balls[2]);
                baseViewHolder.setText(R.id.b4, balls[3]);
                baseViewHolder.setText(R.id.b5, balls[4]);
                baseViewHolder.setText(R.id.b6, balls[5]);
                baseViewHolder.setText(R.id.b7, balls[6]);
                if ("双色球".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_ssq);
                    baseViewHolder.getView(R.id.lay_b).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setBackgroundResource(R.drawable.comm_ball_red);
                    baseViewHolder.getView(R.id.b7).setBackgroundResource(R.drawable.comm_ball_blue);
                } else if ("七乐彩".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_qlc);
                    baseViewHolder.getView(R.id.lay_b).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setBackgroundResource(R.drawable.comm_ball_red);
                    baseViewHolder.getView(R.id.b7).setBackgroundResource(R.drawable.comm_ball_red);
                } else if ("大乐透".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_lotto);
                    baseViewHolder.getView(R.id.lay_b).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setBackgroundResource(R.drawable.comm_ball_blue);
                    baseViewHolder.getView(R.id.b7).setBackgroundResource(R.drawable.comm_ball_blue);
                } else if ("排列三".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_pl3);
                    baseViewHolder.getView(R.id.lay_b).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.GONE);
                } else if ("排列五".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_pl5);
                    baseViewHolder.getView(R.id.lay_b).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.GONE);
                } else {
                    baseViewHolder.getView(R.id.lay_b).setVisibility(View.GONE);
                }
                break;
            case MultipleItem.MUKUAI2:
                baseViewHolder.setText(R.id.title, multipleItem.getTitle())
                        .setText(R.id.time, multipleItem.getPubTime());
                String[] balls2 = multipleItem.getContent().split(",");
                baseViewHolder.setText(R.id.b1, balls2[0]);
                baseViewHolder.setText(R.id.b2, balls2[1]);
                baseViewHolder.setText(R.id.b3, balls2[2]);
                baseViewHolder.setText(R.id.b4, balls2[3]);
                baseViewHolder.setText(R.id.b5, balls2[4]);
                baseViewHolder.setText(R.id.b6, balls2[5]);
                baseViewHolder.setText(R.id.b7, balls2[6]);
                if ("双色球".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_ssq);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setBackgroundResource(R.drawable.comm_ball_red);
                    baseViewHolder.getView(R.id.b7).setBackgroundResource(R.drawable.comm_ball_blue);
                } else if ("七乐彩".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_qlc);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setBackgroundResource(R.drawable.comm_ball_red);
                    baseViewHolder.getView(R.id.b7).setBackgroundResource(R.drawable.comm_ball_red);
                } else if ("大乐透".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_lotto);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setBackgroundResource(R.drawable.comm_ball_blue);
                    baseViewHolder.getView(R.id.b7).setBackgroundResource(R.drawable.comm_ball_blue);
                } else if ("排列三".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_pl3);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.GONE);
                } else if ("排列五".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_pl5);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.GONE);
                } else if ("七星彩".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_qxc);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setBackgroundResource(R.drawable.comm_ball_red);
                    baseViewHolder.getView(R.id.b7).setBackgroundResource(R.drawable.comm_ball_red);
                } else if ("快三".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_k3);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.GONE);
                } else if ("11选5".equals(multipleItem.getTitle())) {
                    baseViewHolder.setImageResource(R.id.img, R.drawable.lottery_icon_hongyun_11x5);
                    baseViewHolder.getView(R.id.b4).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b5).setVisibility(View.VISIBLE);
                    baseViewHolder.getView(R.id.b6).setVisibility(View.GONE);
                    baseViewHolder.getView(R.id.b7).setVisibility(View.GONE);
                } else {
                    baseViewHolder.getView(R.id.lay_b).setVisibility(View.GONE);
                }
                break;
            case MultipleItem.XINWEN:
                baseViewHolder.setText(R.id.title, multipleItem.getTitle())
                        .setText(R.id.time, multipleItem.getPubTime());
                Glide.with(mContext).load(multipleItem.getUrl()).crossFade().into((ImageView) baseViewHolder.getView(R.id.img));
                break;
        }
    }
}
