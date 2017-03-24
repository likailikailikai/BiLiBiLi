package com.atguigu.bilibili.modle.tuijian.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.tuijian.bean.TuijianBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/24.
 * <p>
 * 作用：
 */

public class TuijianAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<TuijianBean.DataBean> datas;

    public TuijianAdapter(Context mContext, List<TuijianBean.DataBean> data) {
        this.mContext = mContext;
        this.datas = data;
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
            convertView = View.inflate(mContext, R.layout.item_gridview_tuijian, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TuijianBean.DataBean dataBean = datas.get(position);
        Glide.with(mContext).load(dataBean.getCover()).into(viewHolder.itemLiveCover);
        viewHolder.itemLiveGuankan.setText(String.valueOf(dataBean.getPlay()));
        viewHolder.itemLiveTitle.setText(dataBean.getTitle());
        viewHolder.itemliveplay.setText(dataBean.getParam());
        viewHolder.itemLiveFenlei.setText(dataBean.getName());
        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.item_live_cover)
        ImageView itemLiveCover;
        @InjectView(R.id.item_live_guankan)
        TextView itemLiveGuankan;
        @InjectView(R.id.item_live_time)
        TextView itemLiveTime;
        @InjectView(R.id.item_live_title)
        TextView itemLiveTitle;
        @InjectView(R.id.item_live_fenlei)
        TextView itemLiveFenlei;
        @InjectView(R.id.item_live_more)
        TextView itemLiveMore;
        @InjectView(R.id.item_live_layout)
        CardView itemLiveLayout;
        @InjectView(R.id.item_live_play)
        TextView itemliveplay;
        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
