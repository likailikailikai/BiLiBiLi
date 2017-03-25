package com.atguigu.bilibili.modle.zhuifan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.zhuifan.bean.ZhuifanBean;
import com.atguigu.bilibili.view.MyGridView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/25.
 * <p>
 * 作用：
 */

public class ZhuifanAdapter extends RecyclerView.Adapter {

    public static final int LINEARLAYOUT = 0;
    public static final int ZHUIFANTUIJIAN = 1;

    private final Context mContext;
    private final ZhuifanBean.ResultBean datas;
    private final LayoutInflater inflater;

    /**
     * 当前类型
     */
    public int currentType = LINEARLAYOUT;
    private FanjutuijianAdapter adapter;


    public ZhuifanAdapter(Context mContext, ZhuifanBean.ResultBean result) {
        this.mContext = mContext;
        this.datas = result;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == LINEARLAYOUT) {
            currentType = LINEARLAYOUT;
        } else if (position == ZHUIFANTUIJIAN) {
            currentType = ZHUIFANTUIJIAN;
        }
        return currentType;
    }


    /**
     * 当前的类型
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LINEARLAYOUT) {
            return new LinearlayoutViewHolder(mContext, inflater.inflate(R.layout.linear_viewpager, null));
        } else if (viewType == ZHUIFANTUIJIAN) {
            return new ZhuifantuijianViewHolder(mContext, inflater.inflate(R.layout.zhuifantuijian_viewpager, null));
        }
        return null;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == LINEARLAYOUT) {
            LinearlayoutViewHolder viewHolder = (LinearlayoutViewHolder) holder;
        } else if (getItemViewType(position) == ZHUIFANTUIJIAN) {
            ZhuifantuijianViewHolder viewHolder = (ZhuifantuijianViewHolder) holder;
            viewHolder.setData(datas.getSerializing());
        }
    }

    /**
     * 追番推荐
     */
    class ZhuifantuijianViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.iv_fanju)
        ImageView ivFanju;
        @InjectView(R.id.tv_fanjubiaoti)
        TextView tvFanjubiaoti;
        @InjectView(R.id.tvfanju1)
        TextView tvfanju1;
        @InjectView(R.id.rl_fanju_tab)
        RelativeLayout rlFanjuTab;
        @InjectView(R.id.gv_zhuifantuijian)
        MyGridView gvZhuifantuijian;

        private Context mContext;

        public ZhuifantuijianViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
            this.mContext = mContext;
        }

        public void setData(List<ZhuifanBean.ResultBean.SerializingBean> serializing) {
           //设置适配器
            adapter = new FanjutuijianAdapter(mContext,serializing);
            gvZhuifantuijian.setAdapter(adapter);
        }
    }


    /*
    头布局登录的实现
     */
    class LinearlayoutViewHolder extends RecyclerView.ViewHolder {

        public LinearlayoutViewHolder(Context mContext, View itemView) {
            super(itemView);
        }
    }

}
