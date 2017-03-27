package com.atguigu.bilibili.modle.zhibo.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.zhibo.adapter.ZhiBoAdapter;
import com.atguigu.bilibili.modle.zhibo.bean.ZhiBoBean;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.utils.Constants;
import com.atguigu.bilibili.view.CustomEmptyView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;


import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;


/**
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：直播
 */

public class ZhiBoFragment extends BaseFragment {

    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;
    @InjectView(R.id.empty_layout)
    CustomEmptyView emptylayout;

    private ZhiBoAdapter adapter;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_zhi_bo, null);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * 1.把数据绑定到控件上的时候，重新该方法
     * 2.联网请求，把得到的数据绑定到视图上
     */
    @Override
    public void initData() {
        super.initData();
        initSwipeRefreshLayout();
        getDataFromNet();

    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setRefreshing(true);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                getDataFromNet();
            }
        });
    }

    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.BASE_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "联网成功==");
                        processData(response);
                    }
                });
    }

    private void processData(String response) {
        //使用fastjson解析json数据
        ZhiBoBean homeBean = JSON.parseObject(response, ZhiBoBean.class);

        if(mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        Log.e("TAG", "解析数据成功==" + homeBean.getData().getBanner().get(0).getImg());

        //设置RecycleView的适配器
        adapter = new ZhiBoAdapter(mContext, homeBean.getData());
        recyclerview.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(mContext, 1);
        //设置布局管理器
        recyclerview.setLayoutManager(manager);
    }







    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
