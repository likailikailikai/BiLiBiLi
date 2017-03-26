package com.atguigu.bilibili.modle.faxian.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.modle.faxian.adapter.FanjuAdapter;
import com.atguigu.bilibili.modle.faxian.bean.FanjuBean;
import com.atguigu.bilibili.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 情v枫 on 2017/3/25.
 * <p>
 * 作用：
 */

public class FanjuFragment extends BaseFragment {
    @InjectView(R.id.listview)
    ListView listview;
    private FanjuAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_fanju, null);
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
                .url(Constants.FANJU)
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
        FanjuBean fanjuBean = JSON.parseObject(response,FanjuBean.class);
        Log.e("TAG", "番剧数据解析成功=="+fanjuBean.getData());

//设置listview适配器
        adapter = new FanjuAdapter(mContext,fanjuBean.getData());
        listview.setAdapter(adapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
