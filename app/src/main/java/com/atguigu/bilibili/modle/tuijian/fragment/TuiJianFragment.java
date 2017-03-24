package com.atguigu.bilibili.modle.tuijian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.tuijian.activity.TypeActivity;
import com.atguigu.bilibili.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：推荐
 */

public class TuiJianFragment extends BaseFragment {

    @InjectView(R.id.iv_tuijian_biaoqian)
    ImageView ivTuijianBiaoqian;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_tui_jian, null);
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @OnClick(R.id.iv_tuijian_biaoqian)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_tuijian_biaoqian:
                Intent intent = new Intent(mContext, TypeActivity.class);
                mContext.startActivity(intent);
                break;
        }
    }
}
