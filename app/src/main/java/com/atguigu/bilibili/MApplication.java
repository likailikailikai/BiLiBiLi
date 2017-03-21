package com.atguigu.bilibili;

import android.app.Application;
import android.content.Context;


/**
 * Created by aaron on 16/9/7.
 */

public class MApplication extends Application{


    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        // 获取全局上下文
        mContext  = this;

    }



}
