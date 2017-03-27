package com.atguigu.bilibili.modle.zhibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.zhibo.bean.ZhiBoBean;
import com.atguigu.bilibili.playvideo.DanmkuVideoActivity;
import com.atguigu.bilibili.view.CircleImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/24.
 * <p>
 * 作用：
 */

public class HuihuaAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ZhiBoBean.DataBean.PartitionsBean> datas;
    public static final String VIDEO = "video";
    private static final String VT = "vt";

    public HuihuaAdapter(Context mContext, List<ZhiBoBean.DataBean.PartitionsBean> data) {
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
            convertView = View.inflate(mContext, R.layout.item_grid_view, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        List<ZhiBoBean.DataBean.PartitionsBean.LivesBean> lives = datas.get(position).getLives();
//        Glide.with(mContext).load(lives.get(position).getCover().getSrc()).into(viewHolder.ivGrid);
        Glide.with(mContext)
                .load(lives.get(position).getCover().getSrc())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.itemLiveCover);
        Glide.with(mContext)
                .load(lives.get(position).getCover().getSrc())
                .centerCrop()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.itemLiveUserCover);
        viewHolder.itemLiveTitle.setText(lives.get(position).getTitle());
        viewHolder.itemLiveUser.setText(lives.get(position).getOwner().getName());
        viewHolder.itemLiveCount.setText(String.valueOf(lives.get(position).getOnline()));

        final String playurl = lives.get(0).getPlayurl();
        final String title = lives.get(0).getTitle();

        viewHolder.itemLiveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DanmkuVideoActivity.class);
                intent.putExtra(VIDEO,playurl);
                intent.putExtra(VT,title);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @InjectView(R.id.item_live_cover)
        ImageView itemLiveCover;
        @InjectView(R.id.item_live_user_cover)
        CircleImageView itemLiveUserCover;
        @InjectView(R.id.item_live_title)
        TextView itemLiveTitle;
        @InjectView(R.id.item_live_user)
        TextView itemLiveUser;
        @InjectView(R.id.item_live_count)
        TextView itemLiveCount;
        @InjectView(R.id.item_live_layout)
        CardView itemLiveLayout;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
