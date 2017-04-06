package com.atguigu.bilibili.modle.dynamic.fragment;

import android.view.View;
import android.widget.Button;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.view.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 情v枫 on 2017/3/24.
 * <p>
 * 作用：
 */

public class DynamicFragment extends BaseFragment {

    @InjectView(R.id.btn_login)
    Button btnLogin;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_dynamic, null);
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

    @OnClick(R.id.btn_login)
    public void onClick() {
    }
}
