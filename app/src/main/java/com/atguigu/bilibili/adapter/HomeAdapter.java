package com.atguigu.bilibili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.BannersBean;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;


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
    private final BannersBean.DataBean data;

    /**
     * 当前类型
     */
    public int currentType = BANNER;
    @InjectView(R.id.ll_anchor)
    LinearLayout llAnchor;
    @InjectView(R.id.ll_center)
    LinearLayout llCenter;
    @InjectView(R.id.ll_video)
    LinearLayout llVideo;
    @InjectView(R.id.ll_search)
    LinearLayout llSearch;
    @InjectView(R.id.ll_category)
    LinearLayout llCategory;

    public HomeAdapter(Context mContext, BannersBean.DataBean data) {
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

    @OnClick({R.id.ll_anchor, R.id.ll_center, R.id.ll_video, R.id.ll_search, R.id.ll_category})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_anchor:
                Toast.makeText(mContext, "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_center:
                Toast.makeText(mContext, "中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_video:
                Toast.makeText(mContext, "视频", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_search:
                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_category:
                Toast.makeText(mContext, "分类", Toast.LENGTH_SHORT).show();
                break;
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


        public void setData(List<BannersBean.DataBean.BannerBean> bean) {
            //1、得到数据
            //2、设置Banner数据
            List<String> images = new ArrayList<>();
            for (int i = 0; i < bean.size(); i++) {
                images.add(bean.get(i).getImg());
                images.add(bean.get(i).getImg());
                images.add(bean.get(i).getImg());
                images.add(bean.get(i).getImg());
                images.add(bean.get(i).getImg());
                images.add(bean.get(i).getImg());
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
                            Log.e("TAG", "图片加载");
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