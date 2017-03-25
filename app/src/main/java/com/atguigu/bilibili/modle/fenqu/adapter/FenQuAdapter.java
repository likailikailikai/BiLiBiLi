package com.atguigu.bilibili.modle.fenqu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.fenqu.bean.ChannelBean;
import com.atguigu.bilibili.modle.fenqu.bean.DonghuaquBean;
import com.atguigu.bilibili.view.MyGridView;
import com.bumptech.glide.Glide;

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
    public static final int DONGHUA = 1;
//    public static final int BANNER = 2;

    private final Context mContext;
    private final List<ChannelBean.DataBean> data1;

    private final LayoutInflater inflater;
    private final List<DonghuaquBean.DataBean> dhqBean;

    /**
     * 当前类型
     */
    public int currentType = CHANNEL;



    public FenQuAdapter(Context mContext, List<ChannelBean.DataBean> data, List<DonghuaquBean.DataBean> donghuaquBean) {
        this.mContext = mContext;
        this.data1 = data;
        this.dhqBean = donghuaquBean;

        inflater = LayoutInflater.from(mContext);
    }

//    public void setData(){
//
//    }

////    public void setData2(){
//
//    }


    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == CHANNEL) {
            currentType = position;
        } else if (position == DONGHUA) {
            currentType = DONGHUA;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CHANNEL) {
            return new ChannelViewHolder(mContext, inflater.inflate(R.layout.channel_item, null));
        } else if (viewType == DONGHUA) {
            return new DonghuaViewHolder(mContext, inflater.inflate(R.layout.donghuaqu_itempager, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == CHANNEL) {
            ChannelViewHolder viewHolder = (ChannelViewHolder) holder;
            //绑定数据
            viewHolder.setData(data1);
        } else if (position == DONGHUA) {
            DonghuaViewHolder viewholder = (DonghuaViewHolder) holder;
            viewholder.setData(dhqBean,position);
        }
    }

    class DonghuaViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_donghua)
        ImageView ivDonghua;
        @InjectView(R.id.tv_donghuabiaoti)
        TextView tvDonghuabiaoti;
        @InjectView(R.id.rl_donghua_tab)
        RelativeLayout rlDonghuaTab;
        @InjectView(R.id.ll_huuihua_tab)
        LinearLayout llHuuihuaTab;
        @InjectView(R.id.gv_donghuaqu)
        MyGridView gvDonghuaqu;
        @InjectView(R.id.btn_donghua_bottom)
        Button btnDonghuaBottom;
        @InjectView(R.id.iv_donghua_shuaxin)
        TextView ivDonghuaShuaxin;

        private final Context mContext;

        private DonghuaAdapter donghuaAdapter;

        public DonghuaViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.inject(this, itemView);
        }

        public void setData(List<DonghuaquBean.DataBean> dhqBean, int position) {
            final DonghuaquBean.DataBean dataBean = dhqBean.get(position - 1);
            List<DonghuaquBean.DataBean.BodyBean> body1 = dhqBean.get(0).getBody();
//            Glide.with(mContext).load(body.get(0).getCover()).into(ivDonghua);
            tvDonghuabiaoti.setText(dataBean.getTitle());

            donghuaAdapter = new DonghuaAdapter(mContext, dhqBean);
            gvDonghuaqu.setAdapter(donghuaAdapter);
        }

//        public void setData(List<DonghuaquBean.DataBean.BodyBean> body) {
//
//            List<DonghuaquBean.DataBean.BodyBean> body1 = dhqBean.get(0).getBody();
//            Glide.with(mContext).load(body.get(0).getCover()).into(ivDonghua);
//            tvDonghuabiaoti.setText();
//
//            donghuaAdapter = new DonghuaAdapter(mContext, dhqBean);
//            gvDonghuaqu.setAdapter(donghuaAdapter);
//        }donghuaAdapter




        /*public void setData(List<DonghuaquBean.DataBean> datas) {
//            DonghuaquBean.DataBean dataBean = datas.get(getAdapterPosition());
//
////            Glide.with(mContext).load(dataBean.getBody().get(getAdapterPosition()).getCover()).into(itemView);

            //设置Gridview的适配器
            channelAdapter = new ChannelAdapter(mContext, data);
            gvChannel.setAdapter(channelAdapter);
        }*/

//        public void setData(List<ChannelBean.DataBean> data1) {
//            channelAdapter = new ChannelAdapter(mContext, data1);
//            gvDonghuaqu.setAdapter(channelAdapter);
//        }
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
