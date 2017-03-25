package com.atguigu.bilibili.modle.fenqu.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.fenqu.adapter.FenQuAdapter;
import com.atguigu.bilibili.modle.fenqu.bean.ChannelBean;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.modle.fenqu.bean.DonghuaquBean;
import com.atguigu.bilibili.utils.Constants;
import com.atguigu.bilibili.view.CustomEmptyView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

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
    private ChannelBean channelBean;
    private DonghuaquBean donghuaquBean;
    private List<ChannelBean.DataBean> data;
    private List<DonghuaquBean.DataBean> donghuaData;

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

//        initRV();
        getDataFromNet();
//        getDataFromNet2();
    }

    private void getDataFromNet2() {
        OkHttpUtils
                .get()
                .url(Constants.DONGHUAQU)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "动画联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "动画联网成功==");
                        Log.e("TAG", "====" + response);
                        processData2(response);
                    }
                });
    }


    private void processData2(String response) {
        donghuaquBean = JSON.parseObject(response,DonghuaquBean.class);
        Log.e("TAG", "liangwangbvjsdgnvkdshvkdfbvfdnvbfdn=="+donghuaquBean.getData());
        donghuaData = donghuaquBean.getData();
        initRV();
    }


    private void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.FENQU_TAG)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "C联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "C联网成功==");
                        processData(response);
                    }
                });
    }

    private void processData(String response) {
        channelBean = JSON.parseObject(response, ChannelBean.class);
        data = channelBean.getData();
        getDataFromNet2();
        Log.e("TAG", "C数据解析成功==" + channelBean.getVer());
//        adapter = new FenQuAdapter(mContext , channelBean.getData());
//
//        recycle.setAdapter(adapter);
//        //设置布局管理器
//        recycle.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }

    private void initRV() {
        if(data != null && data.size() > 0 && donghuaData != null && donghuaData.size() > 0){
            adapter = new FenQuAdapter(mContext ,data,donghuaData);

            recycle.setAdapter(adapter);
            //设置布局管理器
            recycle.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        }else {
            Toast.makeText(mContext, "联网失败", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

}
