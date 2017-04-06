package com.atguigu.bilibili.modle.tuijian.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atguigu.bilibili.view.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by 情v枫 on 2017/3/24.
 * <p>
 * 作用：
 */

public class TuijianViewPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<BaseFragment> fragments;
    private String[] titles = new String[]{"综合"};
    public TuijianViewPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
