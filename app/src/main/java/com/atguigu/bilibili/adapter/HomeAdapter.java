package com.atguigu.bilibili.adapter;

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
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.activity.WebViewActivity;
import com.atguigu.bilibili.bean.ZhiBoBean;
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
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：
 */

public class HomeAdapter extends RecyclerView.Adapter {


    public static final int BANNER = 0;
    public static final int LINEARLAYOUT = 1;

    private final Context mContext;
    private final LayoutInflater inflater;
    private final ZhiBoBean.DataBean data;

    /**
     * 当前类型
     */
    public int currentType = BANNER;

    public HomeAdapter(Context mContext, ZhiBoBean.DataBean data) {
        this.mContext = mContext;
        this.data = data;
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
        } else if (position == LINEARLAYOUT) {
            currentType = LINEARLAYOUT;
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
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        } else if (viewType == LINEARLAYOUT) {
            return new LinearlayoutViewHolder(mContext, inflater.inflate(R.layout.linearlayout_viewpager, null));
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
        if (position == BANNER) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;
            //绑定数据
            viewHolder.setData(data.getBanner());
        } else if (position == LINEARLAYOUT) {
            LinearlayoutViewHolder viewHolder = (LinearlayoutViewHolder) holder;
        }
    }


    class LinearlayoutViewHolder extends RecyclerView.ViewHolder {

        public LinearlayoutViewHolder(View itemView) {
            super(itemView);
        }

        public LinearlayoutViewHolder(Context mContext, View inflate) {
            super(inflate);
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


        public void setData(final List<ZhiBoBean.DataBean.BannerBean> bean) {
            //1、得到数据
            //2、设置Banner数据
            List<String> images = new ArrayList<>();
            for (int i = 0; i < bean.size(); i++) {
                images.add(bean.get(i).getImg());
//                images.add(bean.get(i).getImg());
//                images.add(bean.get(i).getImg());
//                images.add(bean.get(i).getImg());
//                images.add(bean.get(i).getImg());
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
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
//                    Toast.makeText(mContext, "position=="+position, Toast.LENGTH_SHORT).show();
                    ZhiBoBean.DataBean.BannerBean bannerBean = bean.get(position);
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}