package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.HomeBean;
import com.atguigu.bilibili.utils.Constants;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：
 */

public class HomeAdapter extends RecyclerView.Adapter {


    public static final int BANNER = 0;
    private final Context mContext;
    private final LayoutInflater inflater;
    private final HomeBean.DataBean data;

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        }
        return currentType;
    }

    /**
     * 当前类型
     */
    public int currentType = BANNER;

    public HomeAdapter(Context mContext, HomeBean.DataBean data) {
        this.mContext = mContext;
        this.data = data;
        inflater = LayoutInflater.from(mContext);
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
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
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
            viewHolder.setData(data.getBanner());
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        private Banner banner;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            banner = (Banner) itemView.findViewById(R.id.banner);
        }


        public void setData(List<HomeBean.DataBean.BannerBean> banner) {
            //1、得到数据
            //2、设置Banner数据
            List<String> images = new ArrayList<>();
            for (int i = 0; i < banner.size(); i++) {
                images.add(Constants.BASE_URL + banner.get(i).getImg());
            }

        }
    }
}