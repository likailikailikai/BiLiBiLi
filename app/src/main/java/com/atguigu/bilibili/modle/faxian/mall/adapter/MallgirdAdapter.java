package com.atguigu.bilibili.modle.faxian.mall.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.mall.bean.MallgirdBean;
import com.atguigu.bilibili.modle.faxian.mall.avtivity.GoodsInfoActivity;
import com.atguigu.bilibili.utils.Constants;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/28.
 * <p>
 * 作用：
 */

public class MallgirdAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<MallgirdBean.ResultBean.RecordsBean> datas;


    public MallgirdAdapter(Context mContext, List<MallgirdBean.ResultBean.RecordsBean> records) {
        this.mContext = mContext;
        this.datas = records;
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
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.mallgird_viewpager, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final MallgirdBean.ResultBean.RecordsBean recordsBean = datas.get(position);

        Glide.with(mContext).load(recordsBean.getImgUrl()).into(viewHolder.itemTupian);

        viewHolder.itemLiveTitle.setText(recordsBean.getTitle());
        viewHolder.itemPrice.setText(String.valueOf(recordsBean.getSalvePrice()));

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GoodsInfoActivity.class);
//                intent.putExtra(Constants.TUPIAN,recordsBean.getImgUrl());
//                intent.putExtra(Constants.NAME,recordsBean.getTitle());
//                intent.putExtra(Constants.PRICE,recordsBean.getSalvePrice());
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.item_tupian)
        ImageView itemTupian;
        @InjectView(R.id.item_live_title)
        TextView itemLiveTitle;
        @InjectView(R.id.fuhao)
        TextView fuhao;
        @InjectView(R.id.item_price)
        TextView itemPrice;
        @InjectView(R.id.CardView)
        CardView cardView;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
