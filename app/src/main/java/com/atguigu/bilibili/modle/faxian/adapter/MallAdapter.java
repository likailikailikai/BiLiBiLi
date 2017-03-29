package com.atguigu.bilibili.modle.faxian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.bean.MallbannerBean;
import com.atguigu.bilibili.modle.faxian.bean.MallgirdBean;
import com.atguigu.bilibili.view.MyGridView;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by 情v枫 on 2017/3/28.
 * <p>
 * 作用：
 */

public class MallAdapter extends RecyclerView.Adapter {


    public static final int BANNER = 0;
    public static final int MALLGIRD = 1;
    private final Context mContext;
    private final LayoutInflater inflater;
    private final MallbannerBean.ResultBean result;
    private final MallgirdBean.ResultBean result2;


    /**
     * 当前类型
     */
    public int currentType = BANNER;


    public MallAdapter(Context mContext, MallbannerBean.ResultBean result, MallgirdBean.ResultBean result2) {
        this.mContext = mContext;
        this.result = result;
        this.result2 = result2;

        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        } else if (position == MALLGIRD) {
            currentType = MALLGIRD;
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

        if (viewType == BANNER) {
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.mall_banner_viewpager, null));
        } else if (viewType == MALLGIRD) {
            return new MallGirdViewHolder(mContext, inflater.inflate(R.layout.mall_gird_viewpager, null));
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
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;
            //绑定数据
            viewHolder.setData(result.getModelDetails());
        } else if (getItemViewType(position) == MALLGIRD) {
            MallGirdViewHolder viewHolder = (MallGirdViewHolder) holder;
            //绑定数据
            viewHolder.setData(result2, position);
        }
    }

    class MallGirdViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        @InjectView(R.id.btn)
        Button btn;
        @InjectView(R.id.gv_mall)
        MyGridView gvMall;

        private MallgirdAdapter mallgirdAdapter;

        public MallGirdViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.inject(this, itemView);
        }

        public void setData(final MallgirdBean.ResultBean result2, int position) {
            final MallgirdBean.ResultBean.RecordsBean recordsBean = result2.getRecords().get(position);

            mallgirdAdapter = new MallgirdAdapter(mContext, recordsBean);
            gvMall.setAdapter(mallgirdAdapter);


        }
    }


    class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        private Banner banner;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.inject(this, itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }

        public void setData(List<MallbannerBean.ResultBean.ModelDetailsBean> modelDetails) {
            //设置banner数据
            List<String> images = new ArrayList<>();
            for (int i = 0; i < modelDetails.size(); i++) {
                images.add(modelDetails.get(i).getSmallImageUrl());
            }
            //简单使用
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


        }
    }

}
