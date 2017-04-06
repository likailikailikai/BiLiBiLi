package com.atguigu.bilibili.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SettingsActivity extends AppCompatActivity {

    @InjectView(R.id.ib_back)
    ImageButton ibBack;
    @InjectView(R.id.settings_qingxidu)
    LinearLayout settingsQingxidu;
    @InjectView(R.id.settings_bofangdongzuo)
    LinearLayout settingsBofangdongzuo;
    @InjectView(R.id.settings_xiaochuangchicun)
    LinearLayout settingsXiaochuangchicun;
    @InjectView(R.id.settings_jiema)
    TextView settingsJiema;
    @InjectView(R.id.settings_danmu)
    TextView settingsDanmu;
    @InjectView(R.id.settings_lixian)
    TextView settingsLixian;
    @InjectView(R.id.settings_yinyuetongzhilan)
    LinearLayout settingsYinyuetongzhilan;
    @InjectView(R.id.activity_settings)
    LinearLayout activitySettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.inject(this);
    }
}
