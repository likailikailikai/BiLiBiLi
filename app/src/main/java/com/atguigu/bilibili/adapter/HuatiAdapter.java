package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.WebViewActivity;
import com.atguigu.bilibili.bean.HuatiBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/24.
 * <p>
 * 作用：
 */

public class HuatiAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<HuatiBean.ListBean> datas;

    public HuatiAdapter(Context mContext, List<HuatiBean.ListBean> list) {
        this.mContext = mContext;
        this.datas = list;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.huati_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final HuatiBean.ListBean listBean = datas.get(position);

        Glide.with(mContext)
                .load(listBean.getCover()).into(viewHolder.ivHuati);
        viewHolder.tvHuati.setText(listBean.getTitle());
        viewHolder.itemLiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("title",listBean.getTitle());
                intent.putExtra("link",listBean.getLink());
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_huati)
        ImageView ivHuati;
        @InjectView(R.id.tv_huati)
        TextView tvHuati;
        @InjectView(R.id.item_live_layout)
        CardView itemLiveLayout;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
