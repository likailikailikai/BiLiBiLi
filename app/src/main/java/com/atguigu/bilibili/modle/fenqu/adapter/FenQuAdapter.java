package com.atguigu.bilibili.modle.fenqu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.fenqu.bean.ChannelBean;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by 情v枫 on 2017/3/22.
 * <p>
 * 作用：分区Adapter
 */

public class FenQuAdapter extends RecyclerView.Adapter {

    public static final int CHANNEL = 0;
    private final Context mContext;
    private final List<ChannelBean.DataBean> data;
    private final LayoutInflater inflater;

    /**
     * 当前类型
     */
    public int currentType = CHANNEL;

    public FenQuAdapter(Context mContext, List<ChannelBean.DataBean> data) {
        this.mContext = mContext;
        this.data = data;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == CHANNEL) {
            currentType = position;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CHANNEL) {
            return new ChannelViewHolder(mContext, inflater.inflate(R.layout.channel_item, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == CHANNEL) {
            ChannelViewHolder viewHolder = (ChannelViewHolder) holder;
            //绑定数据
            viewHolder.setData(data);
        }
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        @InjectView(R.id.gridview)
        GridView gvChannel;
        ChannelAdapter channelAdapter;
        public ChannelViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            this.mContext = mContext;
        }

        public void setData(List<ChannelBean.DataBean> data) {
            //设置Gridview的适配器
            channelAdapter = new ChannelAdapter(mContext, data);
            gvChannel.setAdapter(channelAdapter);

        }
    }

}
