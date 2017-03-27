package com.atguigu.bilibili.modle.zhuifan.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.modle.zhuifan.adapter.ZhuifanAdapter;
import com.atguigu.bilibili.modle.zhuifan.bean.ZhuifanBean;
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
 * 作用：
 */

public class ZhuiFanFragment extends BaseFragment {

    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;
    @InjectView(R.id.empty_layout)
    CustomEmptyView emptyLayout;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private ZhuifanAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_zhui_fan, null);
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
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                getDataFromNet();
            }
        });
    }

    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.ZHUIFAN)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG","联网失败=="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG","联网成功==");
                        processData(response);
                    }
                });
    }

    private void processData(String response) {

        ZhuifanBean zhuifanBean = JSON.parseObject(response,ZhuifanBean.class);

        if(swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
        }

        Log.e("TAG", "数据解析成功=="+zhuifanBean.getResult());

        adapter = new ZhuifanAdapter(mContext, zhuifanBean.getResult());
        recyclerview.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(mContext,1);
        //设置布局管理器
        recyclerview.setLayoutManager(manager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
