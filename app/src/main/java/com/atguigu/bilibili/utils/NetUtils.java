package com.atguigu.bilibili.utils;

import android.text.TextUtils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import okhttp3.Call;

/**
 * Created by 情v枫 on 2017/4/6.
 * <p>
 * 作用：NetUtils 封装
 */

public class NetUtils {

    private NetUtils(){}

    private static class Tool{
        private static NetUtils okhttpUtils = new NetUtils();
    }

     public static NetUtils getInstance(){
         return Tool.okhttpUtils;
     }

    /**
     *
     * @param url  url
     * @param resutl  resuelBean 回调bean的接口
     * @return
     */
    public RequestCall okhttpUtilsget(String url,final resultJson resutl){

        if(resutl == null) {
            return null;
        }
        if(TextUtils.isEmpty(url)) {
            resutl.onError("url为空无法请求");
            return null;
        }

        RequestCall build = OkHttpUtils.get().url(url).build();

        build.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                resutl.onError(e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                if(TextUtils.isEmpty(response)) {
                    resutl.onError("空请求 无法解析");
                    return;
                }
                resutl.onResponse(response);
            }
        });

        return build;
    }

    public interface resultJson {
        void onResponse(String bean);

        void onError(String error);
    }


}
