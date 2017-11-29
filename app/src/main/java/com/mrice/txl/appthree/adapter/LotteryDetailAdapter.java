package com.mrice.txl.appthree.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.bean.LotteryDetailBean;
import com.mrice.txl.appthree.databinding.FooterItemBookBinding;
import com.mrice.txl.appthree.databinding.HeaderItemBookBinding;
import com.mrice.txl.appthree.databinding.ItemLotteryDetailBinding;
import com.mrice.txl.appthree.ui.LotteryDetailActivity;
import com.mrice.txl.appthree.utils.PerfectClickListener;
import com.mrice.txl.appthree.utils.TimeUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by cai on 2016/12/15.
 */

public class LotteryDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LotteryDetailActivity context;
    private HashMap<String, Integer> map = new HashMap();

    private int status = 1;
    public static final int LOAD_MORE = 0;
    public static final int LOAD_PULL_TO = 1;
    public static final int LOAD_NONE = 2;
    private static final int LOAD_END = 3;
    private static final int TYPE_TOP = -1;

    private static final int TYPE_FOOTER_BOOK = -2;
    private static final int TYPE_HEADER_BOOK = -3;
    private static final int TYPE_CONTENT_BOOK = -4;
    private List<LotteryDetailBean.PageInfo.LotteryDetailBeanIn> list;

    private int mType;

    public LotteryDetailAdapter(Context context, int type) {
        this.context = (LotteryDetailActivity) context;
        list = new ArrayList<>();
        this.mType = type;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return TYPE_HEADER_BOOK;
        } else if (position + 1 == getItemCount()) {
            return TYPE_FOOTER_BOOK;
        } else {
            return TYPE_CONTENT_BOOK;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER_BOOK:
                HeaderItemBookBinding mBindHeader = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.header_item_book, parent, false);
                return new HeaderViewHolder(mBindHeader.getRoot());
            case TYPE_FOOTER_BOOK:
                FooterItemBookBinding mBindFooter = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.footer_item_book, parent, false);
                return new FooterViewHolder(mBindFooter.getRoot());
            default:
                ItemLotteryDetailBinding mBindLottery = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_lottery_detail, parent, false);
                return new BookViewHolder(mBindLottery.getRoot());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.bindItem();
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            footerViewHolder.bindItem();
        } else if (holder instanceof BookViewHolder) {
            BookViewHolder bookViewHolder = (BookViewHolder) holder;
            if (list != null && list.size() > 0) {
                // 内容从"1"开始
//                DebugUtil.error("------position: "+position);
                bookViewHolder.bindItem(list.get(position - 1), position - 1);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 2;
    }

    /**
     * 处理 GridLayoutManager 添加头尾布局占满屏幕宽的情况
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (isHeader(position) || isFooter(position)) ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    /**
     * 处理 StaggeredGridLayoutManager 添加头尾布局占满屏幕宽的情况
     */
    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams
                && (isHeader(holder.getLayoutPosition()) || isFooter(holder.getLayoutPosition()))) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }

    /**
     * 这里规定 position = 0 时
     * 就为头布局，设置为占满整屏幕宽
     */
    private boolean isHeader(int position) {
        return position >= 0 && position < 1;
    }

    /**
     * 这里规定 position =  getItemCount() - 1时
     * 就为尾布局，设置为占满整屏幕宽
     * getItemCount() 改了 ，这里就不用改
     */
    private boolean isFooter(int position) {
        return position < getItemCount() && position >= getItemCount() - 1;
    }

    /**
     * footer view
     */
    private class FooterViewHolder extends RecyclerView.ViewHolder {

        FooterItemBookBinding mBindFooter;

        FooterViewHolder(View itemView) {
            super(itemView);
            mBindFooter = DataBindingUtil.getBinding(itemView);
            mBindFooter.rlMore.setGravity(Gravity.CENTER);
//            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.dipToPx(context, 40));
//            itemView.setLayoutParams(params);
        }

        private void bindItem() {
            switch (status) {
                case LOAD_MORE:
                    mBindFooter.progress.setVisibility(View.VISIBLE);
                    mBindFooter.tvLoadPrompt.setText("正在加载...");
                    itemView.setVisibility(View.VISIBLE);
                    break;
                case LOAD_PULL_TO:
                    mBindFooter.progress.setVisibility(View.GONE);
                    mBindFooter.tvLoadPrompt.setText("上拉加载更多");
                    itemView.setVisibility(View.VISIBLE);
                    break;
                case LOAD_NONE:
                    System.out.println("LOAD_NONE----");
                    mBindFooter.progress.setVisibility(View.GONE);
                    mBindFooter.tvLoadPrompt.setText("没有更多内容了");
                    break;
                case LOAD_END:
                    itemView.setVisibility(View.GONE);
                default:
                    break;
            }
        }
    }


    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        HeaderItemBookBinding mBindBook;

        HeaderViewHolder(View view) {
            super(view);
            mBindBook = DataBindingUtil.getBinding(view);
        }

        private void bindItem() {
//            mBindBook.setBean(book);
//            mBindBook.executePendingBindings();
        }
    }

    public void updateLoadStatus(int status) {
        this.status = status;
        notifyDataSetChanged();
    }

    public int getLoadStatus() {
        return this.status;
    }


    private class BookViewHolder extends RecyclerView.ViewHolder {

        ItemLotteryDetailBinding mLotterDetailBinding;

        BookViewHolder(View view) {
            super(view);
            mLotterDetailBinding = DataBindingUtil.getBinding(view);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        private void bindItem(final LotteryDetailBean.PageInfo.LotteryDetailBeanIn lotteryDetailBeanIn, int position) {
            mLotterDetailBinding.llItemTop.setOnClickListener(new PerfectClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
//                    WebViewActivity.loadUrl(context, caiBean.getContent(), caiBean.getTitle());
//                    BookDetailActivity.start(context,caiBean,mBindBook.ivTopPhoto);
                }
            });
            if (lotteryDetailBeanIn != null) {
                mLotterDetailBinding.executePendingBindings();
                getResult(lotteryDetailBeanIn, mLotterDetailBinding);
            }
        }
    }

    public int getTypeId() {
        for (int i = 0; i < lotteryType.length; i++) {
            map.put(lotteryType[i], i + 1);
        }
        return map.get(mType);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getResult(LotteryDetailBean.PageInfo.LotteryDetailBeanIn lottery, ItemLotteryDetailBinding mLotterDetailBinding) {
        mLotterDetailBinding.lotteryTime.setText(lotteryType[mType - 1] + "开奖结果");
        try {
            String replace = "";
            if (lottery.getNo().contains("江苏快三")) {
                replace = lottery.getNo().replace("江苏快三", "排列三");
            }
            mLotterDetailBinding.lotteryRankTime.setText(replace + "   " + TimeUtil.longToString(lottery.getNoDate(), TimeUtil.getSdf1()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList list = new ArrayList();
        list.clear();
        list.add(lottery.getQ1());
        list.add(lottery.getQ2());
        list.add(lottery.getQ3());
        list.add(lottery.getQ4());
        list.add(lottery.getQ5());
        list.add(lottery.getQ6());
        list.add(lottery.getQ7());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.width = 75;
        params.height = 75;
        params.leftMargin = (int) context.getResources().getDimension(R.dimen.common_size_8);
        if (mType == 1) {
            mLotterDetailBinding.llBall.removeAllViews();
            for (int i = 0; i < 7; i++) {
                TextView textView = new TextView(context);
                textView.setText("" + list.get(i));
                textView.setBackgroundResource(i == 6 ? R.drawable.bluecircle : R.drawable.redcircle);
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(i == 6 ? context.getResources().getColor(R.color.main_blue) : context.getResources().getColor(R.color.holo_red_light));
                textView.setLayoutParams(params);
                mLotterDetailBinding.llBall.addView(textView);
            }
        } else if (mType == 2) {
            mLotterDetailBinding.llBall.removeAllViews();
            for (int i = 0; i < 7; i++) {
                TextView textView = new TextView(context);
                textView.setText("" + list.get(i));
                textView.setTextColor(i == list.size() - 2 || i == list.size() - 1 ? context.getResources().getColor(R.color.main_blue) : context.getResources().getColor(R.color.holo_red_light));
                textView.setGravity(Gravity.CENTER);
                textView.setBackgroundResource(i == list.size() - 2 || i == list.size() - 1 ? R.drawable.bluecircle : R.drawable.redcircle);
                textView.setLayoutParams(params);
                mLotterDetailBinding.llBall.addView(textView);
            }
        } else {
            fillBall(mLotterDetailBinding, list, params);
        }
    }

    private String[] lotteryType = new String[]{"双色球", "大乐透", "排列五", "福彩快3", "11选5", "排列三", "七星彩", "七乐彩", "快乐彩"};

    private void fillBall(ItemLotteryDetailBinding mLotterDetailBinding, ArrayList list, LinearLayout.LayoutParams params) {
        mLotterDetailBinding.llBall.removeAllViews();
        int ballCount = 0;
        if (mType == 3) {
            ballCount = 5;
        } else if (mType == 4) {
            ballCount = 3;
        } else if (mType == 5) {
            ballCount = 5;
        } else if (mType == 6) {
            ballCount = 3;
        } else if (mType == 7) {
            ballCount = 7;
        } else if (mType == 8) {
            ballCount = 7;
        } else {
            ballCount = 3;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("null") || list.get(i).equals("") || list.get(i).equals(" ")) {
                list.set(i, String.valueOf(new Random().nextInt(10)));
            }
        }
        for (int i = 0; i < ballCount; i++) {
            TextView textView = new TextView(context);
            if (TextUtils.equals(String.valueOf(list.get(i)), "null")) {
                list.set(i, new Random().nextInt(10));
            }
            textView.setText("" + list.get(i));
            textView.setTextColor(context.getResources().getColor(R.color.holo_red_light));
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundResource(R.drawable.redcircle);
            textView.setLayoutParams(params);
            mLotterDetailBinding.llBall.addView(textView);
        }
    }

    public void setType(int type) {
        this.mType = mType;
    }

    public List<LotteryDetailBean.PageInfo.LotteryDetailBeanIn> getList() {
        return list;
    }

    public void setList(List<LotteryDetailBean.PageInfo.LotteryDetailBeanIn> list) {
        this.list.clear();
        this.list = list;
    }

    public void addAll(List<LotteryDetailBean.PageInfo.LotteryDetailBeanIn> list) {
        this.list.addAll(list);
    }

}
