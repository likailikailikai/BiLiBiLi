package com.atguigu.bilibili.modle.faxian.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.mall.mallfragment.MallcartFragment;
import com.atguigu.bilibili.modle.faxian.mall.mallfragment.MallddFragment;
import com.atguigu.bilibili.modle.faxian.mall.mallfragment.MallhomeFragment;
import com.atguigu.bilibili.utils.AppManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MallActivity extends AppCompatActivity {


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.app)
    AppBarLayout app;
    @InjectView(R.id.main_fl)
    FrameLayout mainFl;
    @InjectView(R.id.rb_main)
    RadioButton rbMain;
    @InjectView(R.id.rb_cart)
    RadioButton rbCart;
    @InjectView(R.id.rb_dingdan)
    RadioButton rbDingdan;
    @InjectView(R.id.main_rg)
    RadioGroup mainRg;
    @InjectView(R.id.activity_mall)
    LinearLayout activityMall;
    private MallhomeFragment mallhomeFragment;
    private MallcartFragment mallcartFragment;
    private MallddFragment mallddFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        ButterKnife.inject(this);
        initListener();
        initData();
    }

    private void initListener() {
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switchFragment(checkedId);
            }
        });
    }


    private void switchFragment(int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hiddenFragment(transaction);

        switch (checkedId) {
            case R.id.rb_main:
                if (mallhomeFragment == null) {
                    mallhomeFragment = new MallhomeFragment();
                    transaction.add(R.id.main_fl, mallhomeFragment);
                }
                transaction.show(mallhomeFragment);
                break;
            case R.id.rb_cart:
                if (mallcartFragment == null) {
                    mallcartFragment = new MallcartFragment();
                    transaction.add(R.id.main_fl, mallcartFragment);
                }
                transaction.show(mallcartFragment);
                break;
            case R.id.rb_dingdan:
                if (mallddFragment == null) {
                    mallddFragment = new MallddFragment();
                    transaction.add(R.id.main_fl, mallddFragment);
                }
                transaction.show(mallddFragment);
                break;
        }
        transaction.commit();
    }

    private void hiddenFragment(FragmentTransaction transaction) {
        if (mallhomeFragment != null) {
            transaction.hide(mallhomeFragment);
        }
        if (mallcartFragment != null) {
            transaction.hide(mallcartFragment);
        }
        if (mallddFragment != null) {
            transaction.hide(mallddFragment);
        }
    }

    protected void initData() {
        //添加到APPManager
        AppManager.getInstance().addActivity(this);
        //选默认页面
        switchFragment(R.id.rb_main);
    }


}
