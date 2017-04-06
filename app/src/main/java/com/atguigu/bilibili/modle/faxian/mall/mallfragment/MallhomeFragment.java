package com.atguigu.bilibili.modle.faxian.mall.mallfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.view.base.BaseFragment;
import com.atguigu.bilibili.modle.faxian.mall.adapter.MallAdapter;
import com.atguigu.bilibili.modle.faxian.mall.bean.MallbannerBean;
import com.atguigu.bilibili.modle.faxian.mall.bean.MallgirdBean;
import com.atguigu.bilibili.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 情v枫 on 2017/3/28.
 * <p>
 * 作用：
 */

public class MallhomeFragment extends BaseFragment {


    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;
    private MallAdapter adapter;


    private MallbannerBean mallbannerBean;
    private MallbannerBean.ResultBean result;
    private MallgirdBean mallgirdBean;
    private MallgirdBean.ResultBean result2;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_mallhome, null);
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
                .url(Constants.MALLBANNER)
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
        mallbannerBean = JSON.parseObject(response,MallbannerBean.class);
        result = mallbannerBean.getResult();
        getDataFromNet2();
        Log.e("TAG", "mall数据解析成功=="+ mallbannerBean.getResult().getModelDetails().get(0).getSmallImageUrl());
    }

    private void getDataFromNet2() {
        OkHttpUtils
                .get()
                .url(Constants.MALLGIRDVIEW)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "Girdview联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "Girdview联网成功==");
                        processData2(response);
                    }
                });
    }

    private void processData2(String response) {
        mallgirdBean = JSON.parseObject(response,MallgirdBean.class);
        Log.e("TAG", "MallGird数据解析成功=="+mallgirdBean.getResult());
        result2 =  mallgirdBean.getResult();
        initRV();
    }
    private void initRV() {
        if(result != null && result.getModelDetails().size() > 0 && result2 != null && result2.getRecords().size() > 0) {
            adapter = new MallAdapter(mContext, result,result2);
            recyclerview.setAdapter(adapter);

            GridLayoutManager manager = new GridLayoutManager(mContext, 1);
            //设置布局管理器
            recyclerview.setLayoutManager(manager);
        }else{
            Toast.makeText(mContext, "联网失败", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
