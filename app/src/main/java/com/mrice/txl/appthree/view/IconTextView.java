package com.mrice.txl.appthree.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrice.txl.appthree.R;
import com.mrice.txl.appthree.utils.CommonUtils;


/**
 * Created by admin on 2017/2/24.
 */

public class IconTextView extends LinearLayout {
    public IconTextView(Context context) {
        super(context);
        initView(context, R.drawable.icon_tag_normal, "");
    }


    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.iconTextView);

        int icon = ta.getResourceId(R.styleable.iconTextView_left_icon, R.drawable.icon_tag_normal);
        String name = ta.getString(R.styleable.iconTextView_name);

        initView(context, icon, name);
    }

    private void initView(Context context, int icon, String name) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_icontextview, this, true);
        v.findViewById(R.id.ll_commonitem).setBackground(CommonUtils.getDrawable(R.drawable.commonitem_click_bg));
        ImageView iv = (ImageView) v.findViewById(R.id.iv_icon);
        TextView tv = (TextView) v.findViewById(R.id.tv_title);
        iv.setImageResource(icon);
        tv.setText(name);


    }
}
