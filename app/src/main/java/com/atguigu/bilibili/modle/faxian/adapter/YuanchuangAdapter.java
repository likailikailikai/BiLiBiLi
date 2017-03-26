package com.atguigu.bilibili.modle.faxian.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.bean.YuanchuangBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/26.
 * <p>
 * 作用：
 */

public class YuanchuangAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<YuanchuangBean.DataBean> datas;

    public YuanchuangAdapter(Context mContext, List<YuanchuangBean.DataBean> data) {
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
            convertView = View.inflate(mContext, R.layout.yuanchuang_listview, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final YuanchuangBean.DataBean dataBean = datas.get(position);

        Glide.with(mContext).load(dataBean.getCover()).into(viewHolder.imageview);
        viewHolder.tvZhuti.setText(dataBean.getTitle());
        viewHolder.upZhu.setText(dataBean.getName());
        viewHolder.tvPingfen.setText(dataBean.getParam());

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.tv_shu)
        TextView tvShu;
        @InjectView(R.id.imageview)
        ImageView imageview;
        @InjectView(R.id.tv_zhuti)
        TextView tvZhuti;
        @InjectView(R.id.up_zhu)
        TextView upZhu;
        @InjectView(R.id.tv_pingfen)
        TextView tvPingfen;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
