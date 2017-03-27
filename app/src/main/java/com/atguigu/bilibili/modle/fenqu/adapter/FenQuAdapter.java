package com.atguigu.bilibili.modle.fenqu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.atguigu.bilibili.modle.zhibo.activity.BannerWebViewActivity;
import com.atguigu.bilibili.utils.Constants;
import com.atguigu.bilibili.view.MyGridView;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
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
    public static final int GUOCHUANG = 2;

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
//        } else if (position == BANNER) {
//            currentType = BANNER;
        }
        return currentType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == CHANNEL) {
            return new ChannelViewHolder(mContext, inflater.inflate(R.layout.channel_item, null));
        } else if (viewType == DONGHUA) {
            return new DonghuaViewHolder(mContext, inflater.inflate(R.layout.donghuaqu_itempager, null));
//        } else if (viewType == BANNER) {
//            return new BannerViewHolder(mContext, inflater.inflate(R.layout.fenqu_banner_itempager, null));
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
            viewholder.setData(dhqBean, position);
//        } else if (position == GUOCHUANG) {
//            GuochaungViewHolder viewHolder = (GuochaungViewHolder) holder;
//            viewHolder.setData(dhqBean.get(1));
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
        @InjectView(R.id.banner)
        Banner banner;

        private final Context mContext;

        private DonghuaAdapter donghuaAdapter;

        public DonghuaViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.inject(this, itemView);
        }

        public void setData(final List<DonghuaquBean.DataBean> dhqBean, int position) {
            final DonghuaquBean.DataBean dataBean = dhqBean.get(position - 1);
            List<DonghuaquBean.DataBean.BodyBean> body1 = dhqBean.get(0).getBody();
//            Glide.with(mContext).load(body.get(0).getCover()).into(ivDonghua);
            tvDonghuabiaoti.setText(dataBean.getTitle());

            donghuaAdapter = new DonghuaAdapter(mContext, dhqBean);
            gvDonghuaqu.setAdapter(donghuaAdapter);

            //获取banner数据
            List<String> images = new ArrayList<>();
//            for (int i = 0; i < bannerBean.getBottom().size(); i++) {
//                images.add(bannerBean.getBottom().get(i).getImage());
//            }

            for (int i = 0; i < dataBean.getBanner().getBottom().size(); i++) {
                images.add(dataBean.getBanner().getBottom().get(i).getImage());
            }

            banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
                            Glide
                                    .with(context)
                                    .load(path)
                                    .crossFade()
                                    .into(imageView);
                        }
                    })
                    .start();
            Log.e("TAG", "开始banner");
            //设置样式
            banner.setBannerAnimation(BackgroundToForegroundTransformer.class);
            //3、设置banner的点击事件
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    final DonghuaquBean.DataBean.BannerBean.BottomBean bottomBean = dataBean.getBanner().getBottom().get(position);

                    Intent intent = new Intent(mContext, BannerWebViewActivity.class);
                    intent.putExtra(Constants.URL,bottomBean.getUri());
                    intent.putExtra(Constants.TITLE,bottomBean.getTitle());
                    mContext.startActivity(intent);
                }
            });

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
