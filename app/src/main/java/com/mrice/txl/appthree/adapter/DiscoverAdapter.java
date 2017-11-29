package com.mrice.txl.appthree.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrice.txl.appthree.MainActivity;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.bean.NewsBean;
import com.mrice.txl.appthree.databinding.FooterItemBookBinding;
import com.mrice.txl.appthree.databinding.HeaderItemBookBinding;
import com.mrice.txl.appthree.databinding.ItemAndroid1Binding;
import com.mrice.txl.appthree.view.webview.WebViewActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jingbin on 2016/12/15.
 */

public class DiscoverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainActivity context;
    private int i = 0;
    private int status = 1;
    public static final int LOAD_MORE = 0;
    public static final int LOAD_PULL_TO = 1;
    public static final int LOAD_NONE = 2;
    private static final int LOAD_END = 3;
    private static final int TYPE_TOP = -1;

    private static final int TYPE_FOOTER_BOOK = -2;
    private static final int TYPE_HEADER_BOOK = -3;
    private static final int TYPE_CONTENT_BOOK = -4;
    private List<NewsBean.Result.NewsData> list;

    public DiscoverAdapter(Context context) {
        this.context = (MainActivity) context;
        list = new ArrayList<>();

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
                ItemAndroid1Binding mBindBook = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_android1, parent, false);
//                return new BookViewHolder(mBindBook.getRoot());
                return new ViewHolder(mBindBook.getRoot());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.bindItem();
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            footerViewHolder.bindItem();
        } else if (holder instanceof ViewHolder) {
            ViewHolder vh = (ViewHolder) holder;
            if (list != null && list.size() > 0) {
                // 内容从"1"开始
//                DebugUtil.error("------position: "+position);
                vh.bindItem(list.get(position - 1));
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

    private class ViewHolder extends RecyclerView.ViewHolder {
        ItemAndroid1Binding mBindAndroid;

        ViewHolder(View itemView) {
            super(itemView);
            mBindAndroid = DataBindingUtil.getBinding(itemView);
        }

        private void bindItem(final NewsBean.Result.NewsData object) {
            mBindAndroid.tvAndroidTitle.setText(object.getTitle());
            mBindAndroid.tvDescription.setText(object.getAuthor_name());
            mBindAndroid.tvMiddle.setText("");
            mBindAndroid.tvAndroidTime.setText(object.getDate());
            mBindAndroid.executePendingBindings();
            Glide.with(context).load(object.getThumbnail_pic_s()).into(mBindAndroid.ivAndroidPic);
            mBindAndroid.llWelfareOther.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick(View v) {
                    WebViewActivity.loadUrl(v.getContext(), object.getUrl(), object.getTitle());
                }
            });
        }
    }
//    private class BookViewHolder extends RecyclerView.ViewHolder {
//
//        ItemBookBinding mBindBook;
//
//        BookViewHolder(View view) {
//            super(view);
//            mBindBook = DataBindingUtil.getBinding(view);
//        }
//
//        private void bindItem(final DiscoverBean.PageInfo.DiscoverCaiBean caiBean, int position) {
//            mBindBook.setBean(caiBean);
//            mBindBook.executePendingBindings();
//            ImgLoadUtil.showImg(mBindBook.ivTopPhoto, caiBean.getPhontoImg());
//            try {
//                mBindBook.tvTime.setText(TimeUtil.longToString(Long.parseLong(caiBean.getCreateTime()), TimeUtil.getSdf1()));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            mBindBook.llItemTop.setOnClickListener(new PerfectClickListener() {
//                @Override
//                protected void onNoDoubleClick(View v) {
//                    WebViewActivity.loadUrl(context, caiBean.getContent(), caiBean.getTitle());
////                    BookDetailActivity.start(context,caiBean,mBindBook.ivTopPhoto);
//                }
//            });
//
////            ViewGroup.LayoutParams params=iVFilm.getLayoutParams();
////            int width= ScreenUtils.getScreenWidthDp(context);
////            int ivWidth=(width-ScreenUtils.dipToPx(context,80))/3;
////            params.width=ivWidth;
////            double height=(420.0/300.0)*ivWidth;
////            params.height=(int)height;
////            iVFilm.setLayoutParams(params);
//        }
//    }

    public List<NewsBean.Result.NewsData> getList() {
        return list;
    }

    public void setList(List<NewsBean.Result.NewsData> list) {
        this.list.clear();
        this.list = list;
    }

    public void addAll(List<NewsBean.Result.NewsData> list) {
        this.list.addAll(list);
    }

}
