package com.atguigu.bilibili.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.adapter.MainViewPagerAdapter;
import com.atguigu.bilibili.view.base.BaseFragment;
import com.atguigu.bilibili.download.DownloadListActivity;
import com.atguigu.bilibili.modle.dynamic.fragment.DynamicFragment;
import com.atguigu.bilibili.modle.faxian.fragment.FaXianFragment;
import com.atguigu.bilibili.modle.fenqu.fragment.FenQuFragment;
import com.atguigu.bilibili.modle.tuijian.fragment.TuiJianFragment;
import com.atguigu.bilibili.modle.zhibo.fragment.ZhiBoFragment;
import com.atguigu.bilibili.modle.zhuifan.fragment.ZhuiFanFragment;
import com.atguigu.bilibili.view.view.CircleImageView;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.ib_main_lift)
    ImageView ibMainLift;
    @InjectView(R.id.toolbar_user_avatar)
    CircleImageView toolbarUserAvatar;
    @InjectView(R.id.tv_main)
    TextView tvMain;
    @InjectView(R.id.ib_main_game)
    ImageView ibMainGame;
    @InjectView(R.id.ib_main_down)
    ImageView ibMainDown;
    @InjectView(R.id.ib_main_search)
    ImageView ibMainSearch;
    @InjectView(R.id.toolBar)
    Toolbar toolBar;
    @InjectView(R.id.tabLayout)
    TabLayout tabLayout;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorlayout;
    @InjectView(R.id.toolbar_user_left)
    CircleImageView toolbarUserLeft;
    @InjectView(R.id.ib_main_yueliang)
    ImageButton ibMainYueliang;
    @InjectView(R.id.shang)
    RelativeLayout shang;
    @InjectView(R.id.ll_home)
    LinearLayout llHome;
    @InjectView(R.id.ll_huiyuan)
    LinearLayout llHuiyuan;
    @InjectView(R.id.ll_jifen)
    LinearLayout llJifen;
    @InjectView(R.id.ll_huancun)
    LinearLayout llHuancun;
    @InjectView(R.id.view)
    View view;
    @InjectView(R.id.ll_shaohou)
    LinearLayout llShaohou;
    @InjectView(R.id.ll_shoucang)
    LinearLayout llShoucang;
    @InjectView(R.id.ll_lishi)
    LinearLayout llLishi;
    @InjectView(R.id.ll_guanzhu)
    LinearLayout llGuanzhu;
    @InjectView(R.id.ll_qianbao)
    LinearLayout llQianbao;
    @InjectView(R.id.view2)
    View view2;
    @InjectView(R.id.ll_zhuti)
    LinearLayout llZhuti;
    @InjectView(R.id.ll_shezhi)
    LinearLayout llShezhi;
    @InjectView(R.id.relativelayout)
    RelativeLayout relativelayout;
    @InjectView(R.id.activity_main)
    DrawerLayout activityMain;
    private ArrayList<BaseFragment> fragments;
    private MainViewPagerAdapter adapter;

    private boolean isOpen = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initFragment();
        initData();

    }

    private void initData() {

        //设置适配器
        adapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.setTabMode(tabLayout.MODE_FIXED);

    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ZhiBoFragment());
        fragments.add(new TuiJianFragment());
        fragments.add(new ZhuiFanFragment());
        fragments.add(new FenQuFragment());
        fragments.add(new DynamicFragment());
        fragments.add(new FaXianFragment());

    }

    @OnClick({R.id.ib_main_lift, R.id.toolbar_user_avatar, R.id.tv_main, R.id.ib_main_game, R.id.ib_main_down, R.id.ib_main_search, R.id.toolbar_user_left, R.id.ll_home, R.id.ll_huiyuan, R.id.ll_jifen, R.id.ll_huancun, R.id.ll_shaohou, R.id.ll_shoucang, R.id.ll_lishi, R.id.ll_guanzhu, R.id.ll_qianbao, R.id.ll_zhuti, R.id.ll_shezhi, R.id.ib_main_yueliang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_main_lift:
                Toast.makeText(MainActivity.this, "进入左侧菜单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_user_avatar:
                Toast.makeText(MainActivity.this, "进入左侧菜单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_main:
                Toast.makeText(MainActivity.this, "进入左侧菜单", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_main_game:
                Toast.makeText(MainActivity.this, "进入游戏中心", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_main_down:
//                Toast.makeText(MainActivity.this, "进入管理缓存", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this,DownloadListActivity.class);
                startActivity(intent2);
                break;
            case R.id.ib_main_search:
                // Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                SearchFragment searchFragment = SearchFragment.newInstance();
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        //这里处理逻辑
                        Toast.makeText(MainActivity.this, keyword, Toast.LENGTH_SHORT).show();
                    }
                });
                searchFragment.show(getSupportFragmentManager(), SearchFragment.TAG);
                break;
            case R.id.toolbar_user_left:
//                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.ib_main_yueliang:
                Toast.makeText(MainActivity.this, "更换皮肤", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_home:
                Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_huiyuan:
                Toast.makeText(MainActivity.this, "我的大会员", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_jifen:
                Toast.makeText(MainActivity.this, "会员积分", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_huancun:
                Toast.makeText(MainActivity.this, "离线缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_shaohou:
                Toast.makeText(MainActivity.this, "稍后再看", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_shoucang:
                Toast.makeText(MainActivity.this, "收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_lishi:
                Toast.makeText(MainActivity.this, "历史记录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_guanzhu:
                Toast.makeText(MainActivity.this, "关注", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_qianbao:
                Toast.makeText(MainActivity.this, "钱包", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_zhuti:
                Toast.makeText(MainActivity.this, "主题", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_shezhi:
//                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
    }

    private int startY;
    private int startX;
    private boolean isScrollY;
    private boolean isFirst;

    //tollBar 回弹效果
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int eventY = (int) ev.getY();
        int eventX = (int) ev.getX();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = eventY;
                startX = eventX;
                isFirst = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isFirst) {
                    if (Math.abs(eventX - startX) > Math.abs(eventY - startY) && Math.abs(eventX - startX) > toolBar.getHeight() * 0.30) {
                        isScrollY = false;
                        isFirst = false;
                        appbar.setExpanded(isOpen);
                    } else if (Math.abs(eventY - startY) > Math.abs(eventX - startX) && Math.abs(eventY - startY) > toolBar.getHeight() * 0.30) {
                        isScrollY = true;
                        isFirst = false;
                    }
                }
                if (isOpen) {
                    if (startY < eventY) {
                        startY = eventY;
                    }
                } else {
                    if (startY > eventY) {
                        startY = eventY;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isScrollY) {
                    if (isOpen) {
                        if (startY - eventY > toolBar.getHeight() * 0.36) {
                            appbar.setExpanded(false);
                            isOpen = false;
                        } else {
                            appbar.setExpanded(true);
                            isOpen = true;
                        }
                    } else {
                        if (eventY - startY > toolBar.getHeight() * 0.36) {
                            appbar.setExpanded(true);
                            isOpen = true;
                        } else {
                            appbar.setExpanded(false);
                            isOpen = false;
                        }
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    //点两次退出
    private boolean isDouble = false;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isDouble) {
                //退出
                finish();
            }
            Toast.makeText(this, "再点击一次退出应用", Toast.LENGTH_SHORT).show();
            isDouble = true;
            //超两秒改为isDouble
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isDouble = false;
                }
            }, 2000);

//            CountDownTimer timer = new CountDownTimer(10000,1000) {
//                //第一个参数是总时间，，第二个参数是间隔时间
//                @Override
//                public void onTick(long millisUntilFinished) {
//                    //每倒计时一次调用一次
//                }
//
//                @Override
//                public void onFinish() {
//                    //执行完成后调用
//                }
//            }.start();

            return true;

        }
        return super.onKeyUp(keyCode, event);
    }

}
