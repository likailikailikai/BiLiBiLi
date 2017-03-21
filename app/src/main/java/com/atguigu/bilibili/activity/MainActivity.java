package com.atguigu.bilibili.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.ListView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.MainViewPagerAdapter;
import com.atguigu.bilibili.fragment.BaseFragment;
import com.atguigu.bilibili.fragment.FaXianFragment;
import com.atguigu.bilibili.fragment.FenQuFragment;
import com.atguigu.bilibili.fragment.TuiJianFragment;
import com.atguigu.bilibili.fragment.ZhiBoFragment;
import com.atguigu.bilibili.fragment.ZhuiFanFragment;
import com.atguigu.bilibili.view.CircleImageView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.ib_main_lift)
    ImageButton ibMainLift;
    @InjectView(R.id.toolbar_user_avatar)
    CircleImageView toolbarUserAvatar;
    @InjectView(R.id.toolBar)
    Toolbar toolBar;
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorlayout;
    @InjectView(R.id.listview)
    ListView listview;
    @InjectView(R.id.activity_main)
    DrawerLayout activityMain;
    private ArrayList<BaseFragment> fragments;
    private MainViewPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initFragment();
        initData();

    }

    private void initData() {

        //设置适配器
        adapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);

    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiBoFragment());
        fragments.add(new TuiJianFragment());
        fragments.add(new ZhuiFanFragment());
        fragments.add(new FenQuFragment());
        fragments.add(new FaXianFragment());
    }

}
