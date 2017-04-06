package com.atguigu.bilibili.modle.faxian.mall.avtivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class GoodsInfoActivity extends AppCompatActivity {


    @InjectView(R.id.ib_good_info_back)
    ImageButton ibGoodInfoBack;
    @InjectView(R.id.ib_good_info_more)
    ImageButton ibGoodInfoMore;
    @InjectView(R.id.iv_good_info_image)
    ImageView ivGoodInfoImage;
    @InjectView(R.id.tv_good_info_name)
    TextView tvGoodInfoName;
    @InjectView(R.id.tv_good_info_price)
    TextView tvGoodInfoPrice;
    @InjectView(R.id.tv_good_info_callcenter)
    TextView tvGoodInfoCallcenter;
    @InjectView(R.id.tv_good_info_collection)
    TextView tvGoodInfoCollection;
    @InjectView(R.id.tv_good_info_cart)
    TextView tvGoodInfoCart;
    @InjectView(R.id.btn_good_info_addcart)
    Button btnGoodInfoAddcart;
    @InjectView(R.id.ll_goods_root)
    LinearLayout llGoodsRoot;
    @InjectView(R.id.tv_more_share)
    TextView tvMoreShare;
    @InjectView(R.id.tv_more_search)
    TextView tvMoreSearch;
    @InjectView(R.id.tv_more_home)
    TextView tvMoreHome;
    @InjectView(R.id.btn_more)
    Button btnMore;
    @InjectView(R.id.ll_root)
    LinearLayout llRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.ib_good_info_back, R.id.ib_good_info_more, R.id.tv_good_info_callcenter, R.id.tv_good_info_collection, R.id.tv_good_info_cart, R.id.btn_good_info_addcart, R.id.tv_more_share, R.id.tv_more_search, R.id.tv_more_home, R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_good_info_back:
                finish();
                break;
            case R.id.ib_good_info_more:
                Toast.makeText(GoodsInfoActivity.this, "更多", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_good_info_callcenter:
                break;
            case R.id.tv_good_info_collection:
                break;
            case R.id.tv_good_info_cart:
                break;
            case R.id.btn_good_info_addcart:
                Toast.makeText(GoodsInfoActivity.this, "添加购物车", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_share:
                Toast.makeText(GoodsInfoActivity.this, "分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_search:
                Toast.makeText(GoodsInfoActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_more_home:
                break;
            case R.id.btn_more:
                break;
        }
    }
}
