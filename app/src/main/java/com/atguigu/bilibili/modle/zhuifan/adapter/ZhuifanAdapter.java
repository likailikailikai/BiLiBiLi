package com.atguigu.bilibili.modle.zhuifan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.zhibo.adapter.ZhiBoAdapter;
import com.atguigu.bilibili.modle.zhuifan.bean.ZhuifanBean;

/**
 * Created by 情v枫 on 2017/3/25.
 * <p>
 * 作用：
 */

public class ZhuifanAdapter extends RecyclerView.Adapter {

    public static final int LINEARLAYOUT = 0;

    private final Context mContext;
    private final ZhuifanBean.ResultBean datas;
    private final LayoutInflater inflater;

    /**
     * 当前类型
     */
    public int currentType = LINEARLAYOUT;


    public ZhuifanAdapter(Context mContext, ZhuifanBean.ResultBean result) {
        this.mContext = mContext;
        this.datas = result;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == LINEARLAYOUT) {
            currentType = LINEARLAYOUT;
        }
        return currentType;
    }


    /**
     * 当前的类型
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LINEARLAYOUT) {
            return new LinearlayoutViewHolder(mContext, inflater.inflate(R.layout.linear_viewpager,null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)== LINEARLAYOUT) {
            LinearlayoutViewHolder viewHolder = (LinearlayoutViewHolder) holder;
        }
    }

    class LinearlayoutViewHolder extends RecyclerView.ViewHolder {

        public LinearlayoutViewHolder(Context mContext, View itemView) {
            super(itemView);
        }
    }

}
