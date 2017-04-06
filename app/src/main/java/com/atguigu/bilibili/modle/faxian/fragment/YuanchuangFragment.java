package com.atguigu.bilibili.modle.faxian.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.view.base.BaseFragment;
import com.atguigu.bilibili.modle.faxian.adapter.YuanchuangAdapter;
import com.atguigu.bilibili.modle.faxian.bean.YuanchuangBean;
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

public class YuanchuangFragment extends BaseFragment {
    @InjectView(R.id.listview)
    ListView listview;
    private YuanchuangAdapter adapter;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_yuanchuang, null);
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
                .url(Constants.YUANCHUANG)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "----------联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "-----------联网成功==");
                        processData(response);
                    }
                });
    }

    private void processData(String response) {
        YuanchuangBean yuanchuangBean = JSON.parseObject(response,YuanchuangBean.class);
        Log.e("TAG", "原创数据解析成功=="+yuanchuangBean.getData());

        //设置listview适配器
        adapter = new YuanchuangAdapter(mContext,yuanchuangBean.getData());
        listview.setAdapter(adapter);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
