package com.mrice.txl.appthree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mrice.txl.appthree.R;

import java.util.List;

/**
 * Created by Mr on 2017/11/24.
 */

public class StarAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private ViewHolder viewHolder;

    public StarAdapter(Context context, List<String> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.star_item, null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.content = (TextView) view.findViewById(R.id.content);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String str=list.get(i);
        String[] item=str.split("\\|");
        switch (Integer.parseInt(item[0])){
            case 1:
                viewHolder.title.setText("双色球");
                break;
            case 2:
                viewHolder.title.setText("大乐透");
                break;
            case 3:
                viewHolder.title.setText("快3");
                break;
            case 4:
                viewHolder.title.setText("排列三");
                break;
            case 5:
                viewHolder.title.setText("排列五");
                break;
            case 7:
                viewHolder.title.setText("七乐彩");
                break;
            case 8:
                viewHolder.title.setText("七星彩");
                break;
        }
        viewHolder.content.setText(item[1]);
        return view;
    }

    final class ViewHolder{
        TextView title;
        TextView content;
    }
}
