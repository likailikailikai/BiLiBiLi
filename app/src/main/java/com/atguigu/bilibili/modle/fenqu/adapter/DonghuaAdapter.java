package com.atguigu.bilibili.modle.fenqu.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.fenqu.bean.DonghuaquBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/25.
 * <p>
 * 作用：
 */

public class DonghuaAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<DonghuaquBean.DataBean> donghuaquBean;

    public DonghuaAdapter(Context mContext, List<DonghuaquBean.DataBean> donghuaquBean) {
        this.mContext = mContext;
        this.donghuaquBean = donghuaquBean;
    }

    @Override
    public int getCount() {
        return donghuaquBean.size();
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
            convertView = View.inflate(mContext, R.layout.item_gridview_donghuaqu, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DonghuaquBean.DataBean dataBean = donghuaquBean.get(position);
        Glide.with(mContext).load(dataBean.getBody().get(0).getCover()).into(viewHolder.itemLiveCover);

        viewHolder.itemLiveTitle.setText(dataBean.getBody().get(0).getTitle());
        viewHolder.itemLivePlay.setText(String.valueOf(dataBean.getBody().get(0).getPlay()));
        viewHolder.itemLiveGuankan.setText(String.valueOf(dataBean.getBody().get(0).getDanmaku()));

        return convertView;
    }



    static class ViewHolder {
        @InjectView(R.id.item_live_cover)
        ImageView itemLiveCover;
        @InjectView(R.id.item_live_title)
        TextView itemLiveTitle;
        @InjectView(R.id.item_live_guankan)
        TextView itemLiveGuankan;
        @InjectView(R.id.item_live_play)
        TextView itemLivePlay;
        @InjectView(R.id.item_live_layout)
        CardView itemLiveLayout;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
