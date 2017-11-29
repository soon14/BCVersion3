package com.mrice.txl.appthree.adapter;

import android.view.ViewGroup;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.baseadapter.BaseRecyclerViewAdapter;
import com.mrice.txl.appthree.base.baseadapter.BaseRecyclerViewHolder;
import com.mrice.txl.appthree.databinding.ItemEmptyBinding;


/**
 * Created by jingbin on 2016/12/24.
 */

public class EmptyAdapter extends BaseRecyclerViewAdapter<String> {
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_empty);
    }

    class ViewHolder extends BaseRecyclerViewHolder<String, ItemEmptyBinding> {

        public ViewHolder(ViewGroup parent, int item_empty) {
            super(parent, item_empty);
        }

        @Override
        public void onBindViewHolder(String object, int position) {
            binding.setString(object);
        }
    }
}
