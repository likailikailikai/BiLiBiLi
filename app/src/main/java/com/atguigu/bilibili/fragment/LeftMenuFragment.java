package com.atguigu.bilibili.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.atguigu.bilibili.activity.MainActivity;
import com.atguigu.bilibili.utils.DensityUtil;


/**
 * Created by Baby on 2017/2/5.
 * 左侧菜单
 */

public class LeftMenuFragment extends BaseFragment {
    private ListView listView;
    private int prePosition = 0;

    @Override
    public View initView() {
        listView = new ListView(mContext);
        listView.setPadding(0, DensityUtil.dip2px(mContext, 40), 0, 0);
        listView.setBackgroundColor(Color.WHITE);
        //设置监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //1.记录位置和刷新适配器
                prePosition = position;

                //2.关闭侧滑菜单
                MainActivity mainActivity = (MainActivity) mContext;
                mainActivity.getSlidingMenu().toggle();//关<->开

            }
        });

        return listView;
    }

    @Override
    public void initData() {
        super.initData();
    }

}

