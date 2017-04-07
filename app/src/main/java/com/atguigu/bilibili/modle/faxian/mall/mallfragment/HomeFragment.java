package com.atguigu.bilibili.modle.faxian.mall.mallfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.mall.bean.HomepageBean;
import com.atguigu.bilibili.view.base.BaseFragment;
import com.atguigu.bilibili.modle.faxian.mall.adapter.MallAdapter;
import com.atguigu.bilibili.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;

/**
 * Created by 情v枫 on 2017/3/28.
 * <p>
 * 作用：
 */

public class HomeFragment extends BaseFragment {


    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;
    private MallAdapter adapter;
    private List<HomepageBean.ResultBean.RecordsBean> records;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_mallhome, null);
        ButterKnife.inject(this, view);
        return view;
    }

    public void initData() {
        OkHttpUtils.get().url(Constants.MALLGIRDVIEW).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String json) {
        HomepageBean homepageBean = JSON.parseObject(json, HomepageBean.class);
        records = homepageBean.getResult().getRecords();
        //设置适配器

        adapter =new MallAdapter(mContext, records);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new GridLayoutManager(mContext,2));

    }
}
