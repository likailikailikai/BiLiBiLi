package com.atguigu.bilibili.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by 情v枫 on 2017/3/24.
 * <p>
 * 作用：
 */

public abstract class BaseAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.inject(this);
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract int getLayoutId();
}
