package com.atguigu.bilibili.modle.tuijian.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.modle.tuijian.adapter.TuijianAdapter;
import com.atguigu.bilibili.modle.tuijian.bean.TuijianBean;
import com.atguigu.bilibili.utils.Constants;
import com.atguigu.bilibili.view.MyGridView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by 情v枫 on 2017/3/24.
 * <p>
 * 作用：
 */

public class ComprehensiveFragment extends BaseFragment {

    @InjectView(R.id.tuijian_grid)
    GridView tuijianGrid;

    private TuijianAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_comprehensive, null);
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
                .url(Constants.TUIJIAN)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "onResponse==" + response);
                        processData(response);
                    }
                });
    }

    private void processData(String response) {
        TuijianBean tuijianBean = JSON.parseObject(response, TuijianBean.class);
        Log.e("TAG", "数据解析成功==" + tuijianBean.getData());

        //设置RecycleView的适配器
        adapter = new TuijianAdapter(mContext, tuijianBean.getData());
        tuijianGrid.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
