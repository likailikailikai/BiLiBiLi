package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.ChannelBean;
import com.atguigu.bilibili.utils.Constants;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/22.
 * <p>
 * 作用：
 */

public class ChannelAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ChannelBean.DataBean> datas;

    public ChannelAdapter(Context mContext, List<ChannelBean.DataBean> data) {
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
            convertView = View.inflate(mContext, R.layout.item_channel, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ChannelBean.DataBean childrenBean = datas.get(position);
        viewHolder.tvChannel.setText(childrenBean.getName());
        //Glide请求图片
        Glide.with(mContext)
                .load(childrenBean.getLogo())
                .crossFade()
                .into(viewHolder.ivChannel);

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_channel)
        ImageView ivChannel;
        @InjectView(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
