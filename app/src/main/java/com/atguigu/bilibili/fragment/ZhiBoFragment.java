package com.atguigu.bilibili.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.HomeBean;
import com.atguigu.bilibili.utils.Constants;
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


    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_zhi_bo, null);
        ButterKnife.inject(this, view);
        return null;
    }

    /**
     * 1.把数据绑定到控件上的时候，重新该方法
     * 2.联网请求，把得到的数据绑定到视图上
     */
    @Override
    public void initData() {
        super.initData();
       // getDataFromNet();

    }

//    private void getDataFromNet() {
//        OkHttpUtils
//                .get()
//                .url(Constants.BASE_URL)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Log.e("TAG", "联网成功=="+e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        Log.e("TAG", "连网失败== ");
//                        processData(response);
//                    }
//                });
//    }
//
//
//    /**
//     * 三种解析方式：fastjson解析数据、gson和手动解析数据
//     * @param response
//     */
//    private void processData(String response) {
//        HomeBean homeBean = JSON.parseObject(response,HomeBean.class);
//        Log.e("TAG", "数据解析成功=="+homeBean.getData().getBanner().get(0).getImg());
//
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
