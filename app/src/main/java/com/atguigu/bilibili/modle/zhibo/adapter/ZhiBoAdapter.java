package com.atguigu.bilibili.modle.zhibo.adapter;

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
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.zhibo.activity.BannerWebViewActivity;
import com.atguigu.bilibili.modle.zhibo.bean.ZhiBoBean;
import com.atguigu.bilibili.utils.Constants;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：
 */

public class ZhiBoAdapter extends RecyclerView.Adapter {


    public static final int BANNER = 0;
    public static final int HUIHUA = 1;

    private final Context mContext;
    private final LayoutInflater inflater;
    private final ZhiBoBean.DataBean data;

    private HuihuaAdapter adapter;

    /**
     * 当前类型
     */
    public int currentType = BANNER;



    public ZhiBoAdapter(Context mContext, ZhiBoBean.DataBean data) {
        this.mContext = mContext;
        this.data = data;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        } else if (position == HUIHUA) {
            currentType = HUIHUA;
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
        } else if (viewType == HUIHUA) {
            return new HuihuaViewHolder(mContext, inflater.inflate(R.layout.huihua_viewpager, null));
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
        } else if (getItemViewType(position) == HUIHUA) {
            HuihuaViewHolder viewHolder = (HuihuaViewHolder) holder;
            viewHolder.setData(data.getPartitions().get(position));
        }
    }

    class HuihuaViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.iv_huuihua)
        ImageView ivHuuihua;
        @InjectView(R.id.tvzhibo)
        TextView tvzhibo;
        @InjectView(R.id.tvhuihua1)
        TextView tvhuihua1;
        @InjectView(R.id.rl_huuihua_tab)
        RelativeLayout rlHuuihuaTab;
        @InjectView(R.id.ll_huuihua_tab)
        LinearLayout llHuuihuaTab;
        @InjectView(R.id.gv_huihuazhuanqu)
        GridView gvHuihuazhuanqu;
        @InjectView(R.id.btn_huihua_bottom)
        Button btnHuihuaBottom;
        @InjectView(R.id.iv_huihua_shuaxin)
        TextView ivHuihuaShuaxin;
        @InjectView(R.id.tv_huihuabiaoti)
        TextView tvhuihuabiaoti;

        public HuihuaViewHolder(Context mContext, View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void setData(ZhiBoBean.DataBean.PartitionsBean partitionsBean) {
            List<ZhiBoBean.DataBean.PartitionsBean> partitions = data.getPartitions();
            Glide.with(mContext).load(partitionsBean.getPartition().getSub_icon().getSrc()).into(ivHuuihua);
            tvzhibo.setText(String.valueOf(partitionsBean.getPartition().getCount()));
            tvhuihuabiaoti.setText(partitionsBean.getPartition().getArea());

            adapter = new HuihuaAdapter(mContext, partitions);
            gvHuihuazhuanqu.setAdapter(adapter);

            Log.e("TAG", "Huihua---------");
        }
    }


    class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Context mContext;
        private Banner banner;

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


        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ButterKnife.inject(this,itemView);
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
                    Intent intent = new Intent(mContext, BannerWebViewActivity.class);
                    intent.putExtra(Constants.URL,bannerBean.getLink());
                    intent.putExtra(Constants.TITLE,bannerBean.getTitle());
                    mContext.startActivity(intent);
                }
            });
        }
        @OnClick({R.id.ll_anchor, R.id.ll_center, R.id.ll_video, R.id.ll_search, R.id.ll_category})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ll_anchor:
                    break;
                case R.id.ll_center:
                    break;
                case R.id.ll_video:
                    break;
                case R.id.ll_search:
                    break;
                case R.id.ll_category:
                    Toast.makeText(mContext, "分类", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}