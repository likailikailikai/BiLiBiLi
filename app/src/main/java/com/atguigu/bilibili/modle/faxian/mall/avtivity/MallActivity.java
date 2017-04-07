package com.atguigu.bilibili.modle.faxian.mall.avtivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.mall.mallfragment.HomeFragment;
import com.atguigu.bilibili.modle.faxian.mall.mallfragment.ShoppingFragment;
import com.atguigu.bilibili.view.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MallActivity extends AppCompatActivity {


    @InjectView(R.id.fl_fl_shopping)
    FrameLayout flFlShopping;
    @InjectView(R.id.rb_home)
    RadioButton rbHome;
    @InjectView(R.id.rb_shopping_cart)
    RadioButton rbShoppingCart;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;

    private List<BaseFragment> fragments;

    private Fragment tempfragment;

    private int postion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        ButterKnife.inject(this);

        initFragment();
        initListener();
    }

    protected void initListener() {

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        postion = 0;
                        break;
                    case R.id.rb_shopping_cart:
                        postion = 1;
                        break;
                }
                Fragment currentfragment = fragments.get(postion);

                switchfragment(currentfragment);
            }
        });
        rgMain.check(R.id.rb_home);
    }

    private void switchfragment(Fragment currentfragment) {
        if (tempfragment != currentfragment) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            if (!currentfragment.isAdded()) {
                if (tempfragment != null) {
                    ft.hide(tempfragment);
                }

                //添加
                ft.add(R.id.fl_fl_shopping, currentfragment);


            } else {
                if (tempfragment != null) {
                    ft.hide(tempfragment);
                }
                ft.show(currentfragment);
            }
            ft.commit();

            tempfragment = currentfragment;
        }
    }


    protected void initView() {
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ShoppingFragment());
    }


}
