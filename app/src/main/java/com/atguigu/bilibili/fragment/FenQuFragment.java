package com.atguigu.bilibili.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.FenQuAdapter;
import com.atguigu.bilibili.bean.ChannelBean;
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
 * 作用：分区
 */

public class FenQuFragment extends BaseFragment {


    @InjectView(R.id.recycle)
    RecyclerView recycle;
    @InjectView(R.id.empty_layout)
    CustomEmptyView emptyLayout;

    private FenQuAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_fen_qu, null);
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
        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.FENQU_TAG)
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
        ChannelBean channelBean = JSON.parseObject(response,ChannelBean.class);
        Log.e("TAG", "数据解析成功=="+channelBean.getVer());

        adapter = new FenQuAdapter(mContext,channelBean.getData());
        recycle.setAdapter(adapter);

        //设置布局管理器
        recycle.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
