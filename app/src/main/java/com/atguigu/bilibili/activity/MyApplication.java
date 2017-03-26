package com.atguigu.bilibili.activity;

import android.app.Application;
import android.content.Context;

import org.xutils.x;


/**
 * Created by Baby on 2017/1/10.
 * 代表整个软件
 */

public class MyApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志...

        // 获取全局上下文
        mContext  = this;
    }
}
