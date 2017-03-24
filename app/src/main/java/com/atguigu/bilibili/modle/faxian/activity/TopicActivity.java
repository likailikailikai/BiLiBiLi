package com.atguigu.bilibili.modle.faxian.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.adapter.HuatiAdapter;
import com.atguigu.bilibili.base.BaseAcitivity;
import com.atguigu.bilibili.modle.faxian.bean.HuatiBean;
import com.atguigu.bilibili.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;
import okhttp3.Call;

public class TopicActivity extends BaseAcitivity {

    private List<HuatiBean.ListBean> list;

    @InjectView(R.id.ib_back)
    ImageButton ibBack;
    @InjectView(R.id.listview)
    ListView listview;
    private HuatiAdapter adapter;

    @Override
    protected void initListener() {

    }


    @Override
    protected void initData() {
        getDataFromNet();
    }

    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.HUATI)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "联网失败=="+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "联网成功==");
                        processData(response);
                    }
                });
    }

    private void processData(String response) {
        HuatiBean huatiBean = JSON.parseObject(response,HuatiBean.class);
        Log.e("TAG", "数据解析成功=="+huatiBean.getList());
        list = huatiBean.getList();

        if(list != null && list.size()>0) {
            //设置适配器
            adapter = new HuatiAdapter(this,list);
            listview.setAdapter(adapter);

        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_topic;
    }


    @OnClick(R.id.ib_back)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_back:
                finish();
                break;
        }
    }
}
