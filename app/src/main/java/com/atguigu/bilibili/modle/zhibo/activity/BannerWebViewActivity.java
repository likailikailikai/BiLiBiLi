package com.atguigu.bilibili.modle.zhibo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.utils.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class BannerWebViewActivity extends AppCompatActivity {

    @InjectView(R.id.ib_back)
    ImageButton ibBack;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.ib_more)
    ImageButton ibMore;
    @InjectView(R.id.webview)
    WebView webview;
    @InjectView(R.id.progressbar)
    ProgressBar progressbar;
    @InjectView(R.id.activity_web_view)
    LinearLayout activityWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.inject(this);
        getData();
    }

    private void getData() {
        WebSettings webSettings = webview.getSettings();
        //设置支持JS
        webSettings.setJavaScriptEnabled(true);
        //设置添加缩放按钮
        webSettings.setBuiltInZoomControls(true);
        //设置双击单击
        webSettings.setUseWideViewPort(true);
        //设置webViewclient，如果没有设置，调起系统的浏览器打开新的连接
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressbar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }
        });
        webview.loadUrl(Constants.BANNER_WEB);
    }

    @OnClick({R.id.ib_back, R.id.ib_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;
            case R.id.ib_more:
                //更多
                break;
        }
    }

}