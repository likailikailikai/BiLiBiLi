package com.atguigu.bilibili.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.atguigu.bilibili.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.iv_back_login)
    ImageView ivBackLogin;
    @InjectView(R.id.forget_password)
    Button forgetPassword;
    @InjectView(R.id.ic_22_hide)
    ImageView ic22Hide;
    @InjectView(R.id.ic_22)
    ImageView ic22;
    @InjectView(R.id.ic_33_hide)
    ImageView ic33Hide;
    @InjectView(R.id.ic_33)
    ImageView ic33;
    @InjectView(R.id.zhuce)
    Button zhuce;
    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.activity_login)
    LinearLayout activityLogin;
    @InjectView(R.id.et_user)
    EditText etuser;
    @InjectView(R.id.et_password)
    EditText etpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
    }


    @OnClick({R.id.iv_back_login, R.id.forget_password, R.id.zhuce, R.id.login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_login:
                finish();
                break;
            case R.id.forget_password:
                Toast.makeText(LoginActivity.this, "忘记密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zhuce:
                break;
            case R.id.login:
                break;
        }
    }
}
