package com.atguigu.bilibili.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.atguigu.bilibili.R;

public class TypeActivity extends AppCompatActivity {

    private String[] titles = new String[]{"我的","动画","国创","音乐","舞蹈","游戏",
            "科技","生活","鬼畜","时尚","娱乐","电影","电视剧"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
    }
}
