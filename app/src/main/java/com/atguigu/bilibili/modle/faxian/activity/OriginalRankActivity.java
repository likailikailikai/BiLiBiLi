package com.atguigu.bilibili.modle.faxian.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.modle.faxian.adapter.YuanchuangphbViewPagerAdapter;
import com.atguigu.bilibili.modle.faxian.fragment.FanjuFragment;
import com.atguigu.bilibili.modle.faxian.fragment.QuanzhanFragment;
import com.atguigu.bilibili.modle.faxian.fragment.YuanchuangFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class OriginalRankActivity extends AppCompatActivity {

    @InjectView(R.id.ib_main_lift)
    ImageView ibMainLift;
    @InjectView(R.id.tv_main)
    TextView tvMain;
    @InjectView(R.id.ib_main_down)
    ImageView ibMainDown;
    @InjectView(R.id.ib_main_search)
    ImageView ibMainSearch;
    @InjectView(R.id.toolBar)
    Toolbar toolBar;
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    private YuanchuangphbViewPagerAdapter adapter;
    private ArrayList<BaseFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_original_rank);
        ButterKnife.inject(this);

        initFragment();
        initData();
    }

    private void initData() {
        //设置适配器
        adapter = new YuanchuangphbViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new YuanchuangFragment());
        fragments.add(new QuanzhanFragment());
        fragments.add(new FanjuFragment());
    }

    @OnClick({R.id.ib_main_lift, R.id.ib_main_down, R.id.ib_main_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_main_lift:
                break;
            case R.id.ib_main_down:
                break;
            case R.id.ib_main_search:
                break;
        }
    }
}
