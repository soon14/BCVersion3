package com.mrice.txl.appthree.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.base.baseadapter.BaseRecyclerViewAdapter;
import com.mrice.txl.appthree.base.baseadapter.BaseRecyclerViewHolder;
import com.mrice.txl.appthree.databinding.LayoutRebackItemBinding;
import com.mrice.txl.appthree.ui.purchase.RebackItem;

/**
 * Created by app on 2017/10/13.
 */
public class RebackAdapter extends BaseRecyclerViewAdapter<RebackItem> {

    private static final int TYPE_DLT = 1;
    private static final int TYPE_SSQ = 2;
    private static final int TYPE_7LC = 3;
    private static final int TYPE_7XC = 4;

    public RebackAdapter(){

    }
    private Context context;
    public RebackAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getItemViewType(int position) {
        if (getData().get(position).getType() == 1) {
            return TYPE_DLT;
        } else if (getData().get(position).getType() == 2) {
            return TYPE_SSQ;
        } else if (getData().get(position).getType() == 3) {
            return TYPE_7LC;
        } else if (getData().get(position).getType() == 4) {
            return TYPE_7XC;
        }
        return super.getItemViewType(position);
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.layout_reback_item);
    }

    private class ViewHolder extends BaseRecyclerViewHolder<RebackItem, LayoutRebackItemBinding> {

        ViewHolder(ViewGroup parent, int title) {
            super(parent, title);
        }

        @Override
        public void onBindViewHolder(RebackItem object, final int position) {
            binding.ballNum.setText(object.getQq());
            binding.b1.setText(object.getBall1());
            binding.b2.setText(object.getBall2());
            binding.b3.setText(object.getBall3());
            binding.b4.setText(object.getBall4());
            binding.b5.setText(object.getBall5());
            binding.b6.setText(object.getBall6());
            binding.b7.setText(object.getBall7());

            if(object.getType()==1){
                binding.b6.setBackgroundResource(R.drawable.ballchoose_blueselector2);
                binding.b6.setTextColor(context.getResources().getColor(R.color.main_blue));
                binding.b7.setBackgroundResource(R.drawable.ballchoose_blueselector2);
                binding.b7.setTextColor(context.getResources().getColor(R.color.main_blue));
            }else if(object.getType()==2){
                binding.b7.setBackgroundResource(R.drawable.ballchoose_blueselector2);
                binding.b7.setTextColor(context.getResources().getColor(R.color.main_blue));
            }
        }
    }
}
