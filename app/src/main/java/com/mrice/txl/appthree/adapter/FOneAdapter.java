package com.mrice.txl.appthree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.ui.me.PageOne;

import java.util.List;

/**
 * Created by app on 2017/10/11.
 */
public class FOneAdapter extends BaseAdapter {

    private Context context;
    private List<PageOne> list;
    private int[] arrs = new int[]{R.drawable.d, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10};
    ViewHolder viewHolder;

    public FOneAdapter(Context context, List<PageOne> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.f_one_item, null);
            viewHolder = new ViewHolder();
            viewHolder.img = (ImageView) view.findViewById(R.id.img);
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.time = (TextView) view.findViewById(R.id.time);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.img.setImageResource(arrs[i]);
        viewHolder.title.setText(list.get(i).getTitle());
        viewHolder.time.setText(list.get(i).getTime());
        return view;
    }

    public final class ViewHolder {
        ImageView img;
        TextView title;
        TextView content;
        TextView time;
        TextView source;
    }
}
