package com.atguigu.bilibili.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atguigu.bilibili.R;
import com.atguigu.bilibili.bean.DiscoverTagBean;
import com.atguigu.bilibili.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.view.flowlayout.TagFlowLayout;


import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;


/**
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：发现
 */

public class FaXianFragment extends BaseFragment {

    @InjectView(R.id.tv_main_faxian)
    TextView tvMainFaxian;
    @InjectView(R.id.flowlayout)
    TagFlowLayout flowlayout;

//    private List<DiscoverTagBean.DataBean.ListBean> dataBeanList;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_fa_xian, null);
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
//        getDataFromNet(Constants.DISCOVER_TAG);
    }

//    private void getDataFromNet(String url) {
//        OkHttpUtils
//                .get()
//                .url(url)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Toast.makeText(mContext, "TagFragment联网失败", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        processData(response);
//                    }
//                });
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    private void processData(String json) {
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
