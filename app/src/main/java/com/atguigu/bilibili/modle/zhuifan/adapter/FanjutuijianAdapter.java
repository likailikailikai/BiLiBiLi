package com.atguigu.bilibili.modle.zhuifan.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.zhuifan.bean.ZhuifanBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.R.attr.data;

/**
 * Created by 情v枫 on 2017/3/25.
 * <p>
 * 作用：
 */

public class FanjutuijianAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ZhuifanBean.ResultBean.SerializingBean> datas;

    public FanjutuijianAdapter(Context mContext, List<ZhuifanBean.ResultBean.SerializingBean> serializing) {
        this.mContext = mContext;
        this.datas = serializing;
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
            convertView = View.inflate(mContext, R.layout.zhuifantuijian_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ZhuifanBean.ResultBean.SerializingBean serializingBean = datas.get(position);

        viewHolder.tvContent.setText(serializingBean.getTitle());
        viewHolder.renshu.setText(serializingBean.getFavourites());

        Glide.with(mContext).load(serializingBean.getCover()).into(viewHolder.ivDefault);

        viewHolder.itemCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "点我", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.iv_default)
        ImageView ivDefault;
        @InjectView(R.id.tv_content)
        TextView tvContent;
        @InjectView(R.id.item_cardview)
        CardView itemCardview;
        @InjectView(R.id.renshu)
        TextView renshu;
        @InjectView(R.id.gengxin)
        TextView gengxin;
        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
