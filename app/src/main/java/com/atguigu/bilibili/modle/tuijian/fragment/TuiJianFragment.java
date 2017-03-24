package com.atguigu.bilibili.modle.tuijian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.MainViewPagerAdapter;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.modle.tuijian.activity.TypeActivity;
import com.atguigu.bilibili.modle.tuijian.adapter.TuijianViewPagerAdapter;
import com.atguigu.bilibili.modle.zhibo.fragment.ZhiBoFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.atguigu.bilibili.R.id.viewpager;

/**
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：推荐
 */

public class TuiJianFragment extends BaseFragment {


    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;
    @InjectView(R.id.iv_tuijian_biaoqian)
    ImageView ivTuijianBiaoqian;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    private TuijianViewPagerAdapter adapter;

    private ArrayList<BaseFragment> fragments;


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
        initFragment();

        //设置适配器
        adapter = new TuijianViewPagerAdapter(getChildFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);


    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ComprehensiveFragment());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.iv_tuijian_biaoqian})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_tuijian_biaoqian:
                Intent intent = new Intent(mContext,TypeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
