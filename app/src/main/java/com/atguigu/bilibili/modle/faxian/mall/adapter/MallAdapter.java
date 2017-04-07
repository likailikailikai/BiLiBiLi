package com.atguigu.bilibili.modle.faxian.mall.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.mall.avtivity.GoodsInfoActivity;
import com.atguigu.bilibili.modle.faxian.mall.bean.HomepageBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/28.
 * <p>
 * 作用：
 */

public class MallAdapter extends RecyclerView.Adapter<MallAdapter.ViewHolder> {

    public static final String IMAGE = "image";
    public static final String NAME = "name";
    public static final String MONEY = "money";

    private final Context mContext;
    private final List<HomepageBean.ResultBean.RecordsBean> datas;

    public MallAdapter(Context mContext, List<HomepageBean.ResultBean.RecordsBean> records) {
        this.mContext = mContext;
        this.datas = records;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_adapter, parent, false));
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HomepageBean.ResultBean.RecordsBean Bean = datas.get(position);

        Glide.with(mContext).load(Bean.getImgUrl()).into(holder.ivImage);
        holder.tvMoney.setText(Bean.getSalvePrice() + "");
        holder.tvName.setText(Bean.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, GoodsInfoActivity.class);
                intent.putExtra(IMAGE, Bean);
//                intent.putExtra(NAME,Bean.getTitle());
//                intent.putExtra(MONEY,Bean.getSalvePrice()+"");
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_image)
        ImageView ivImage;
        @InjectView(R.id.card_view)
        CardView cardView;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.tv_money)
        TextView tvMoney;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
