package com.atguigu.bilibili.modle.faxian.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.bean.MallgirdBean;
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

//    public MallgirdAdapter(Context mContext, MallgirdBean.ResultBean.RecordsBean recordsBean) {
//        this.mContext = mContext;
//        this.datas = recordsBean;
//    }

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

        MallgirdBean.ResultBean.RecordsBean recordsBean = datas.get(position);

        Glide.with(mContext).load(recordsBean.getImgUrl()).into(viewHolder.itemTupian);

        viewHolder.itemLiveTitle.setText(recordsBean.getTitle());
        viewHolder.itemPrice.setText(String.valueOf(recordsBean.getSalvePrice()));

//        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, GoodsInfoActivity.class);
//                intent.putExtra(datas.getImgUrl(),"");
//                intent.putExtra(datas.getTitle(),"");
//                mContext.startActivity(intent);
//            }
//        });

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
