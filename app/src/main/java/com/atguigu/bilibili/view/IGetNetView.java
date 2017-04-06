package com.atguigu.bilibili.view;

/**
 * Created by 情v枫 on 2017/4/6.
 * <p>
 * 作用：
 */

public interface IGetNetView {
    void onSuccess(String json);

    void onError(String error);

    void showLoading();

    void hideLoading();

    String setUrl();

    boolean isShowView();
}
