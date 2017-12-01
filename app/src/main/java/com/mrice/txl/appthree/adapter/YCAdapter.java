package com.mrice.txl.appthree.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.bean.YCItem;

import java.util.List;

/**
 * Created by app on 2017/12/1.
 */
public class YCAdapter extends BaseQuickAdapter<YCItem, BaseViewHolder> {

    private int[] ds = new int[]{R.drawable.head2, R.drawable.head3, R.drawable.head4, R.drawable.head5, R.drawable.head6, R.drawable.head7, R.drawable.head8, R.drawable.head2, R.drawable.head3, R.drawable.head4, R.drawable.head5, R.drawable.head6, R.drawable.head7};

    public YCAdapter(@LayoutRes int layoutResId, @Nullable List<YCItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, YCItem ycItem) {
        baseViewHolder.setText(R.id.name, ycItem.getName())
                .setText(R.id.zj, ycItem.getZj())
                .setText(R.id.lx, ycItem.getLx())
                .setText(R.id.qh, ycItem.getQh())
                .setText(R.id.sj, ycItem.getSj())
                .setImageResource(R.id.headImg, ds[ycItem.getId()]);
    }
}
