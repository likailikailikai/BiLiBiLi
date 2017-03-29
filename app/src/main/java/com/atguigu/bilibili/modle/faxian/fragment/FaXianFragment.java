package com.atguigu.bilibili.modle.faxian.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.base.BaseFragment;
import com.atguigu.bilibili.modle.faxian.activity.InterestActivity;
import com.atguigu.bilibili.modle.faxian.activity.MallActivity;
import com.atguigu.bilibili.modle.faxian.activity.MallWebViewActivity;
import com.atguigu.bilibili.modle.faxian.activity.OriginalRankActivity;
import com.atguigu.bilibili.modle.faxian.activity.TopicActivity;
import com.atguigu.bilibili.modle.faxian.bean.FaXianBean;
import com.atguigu.bilibili.modle.zhibo.activity.BannerWebViewActivity;
import com.atguigu.bilibili.utils.Constants;
import com.github.hymanme.tagflowlayout.OnTagClickListener;
import com.github.hymanme.tagflowlayout.TagFlowLayout;
import com.github.hymanme.tagflowlayout.tags.ColorfulTagView;
import com.github.hymanme.tagflowlayout.tags.DefaultTagView;
import com.google.gson.Gson;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by 情v枫 on 2017/3/21.
 * <p>
 * 作用：发现
 */

public class FaXianFragment extends BaseFragment {


    @InjectView(R.id.ic_hint_search)
    ImageView icHintSearch;
    @InjectView(R.id.ic_scan_erweima)
    ImageView icScanerweima;
    @InjectView(R.id.tv_main_faxian)
    RelativeLayout tvMainFaxian;

    @InjectView(R.id.ll_xingqu)
    LinearLayout llXingqu;
    @InjectView(R.id.ll_huati)
    LinearLayout llHuati;
    @InjectView(R.id.ll_huodong)
    LinearLayout llHuodong;
    @InjectView(R.id.ll_xiaoheiwu)
    LinearLayout llXiaoheiwu;
    @InjectView(R.id.ll_yuanchuang)
    LinearLayout llYuanchuang;
    @InjectView(R.id.ll_quanqu)
    LinearLayout llQuanqu;
    @InjectView(R.id.ll_youxizhongxin)
    LinearLayout llYouxizhongxin;
    @InjectView(R.id.ll_zhoubian_shop)
    LinearLayout llZhoubianShop;
    @InjectView(R.id.tag_flow_layout)
    TagFlowLayout tagFlowLayout;
    private LayoutInflater mInflater;


    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    private List<FaXianBean.DataBean.ListBean> list;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_fa_xian, null);
        ButterKnife.inject(this, view);
        return view;
    }


    /**
     * 1.把数据绑定到控件上的时候，重新该方法
     * 2.联网请求，把得到的数据绑定到视图上
     */
    @Override
    public void initData() {
        super.initData();
        getDataFromNet();
    }

    private void getDataFromNet() {
        RequestParams reques = new RequestParams(Constants.DISCOVER_TAG);
        x.http().get(reques, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                LogUtil.e("onSuccess==" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("onError==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("onFinished==");
            }
        });

    }

    /**
     * 使用Gson解析JSON
     *
     * @param json
     */
    //适配器代码
    private void processData(String json) {
        mInflater = LayoutInflater.from(mContext);
        FaXianBean faXianBean = paraseJson(json);
        list = faXianBean.getData().getList();

        final String[] mVals = new String[list.size()];
        for (int i = 0; i < mVals.length; i++) {
            mVals[i] = list.get(i).getKeyword();

        }


        tagFlowLayout.setTagListener(new OnTagClickListener() {
            @Override
            public void onClick(TagFlowLayout parent, View view, int position) {
                Toast.makeText(mContext, "click==" + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(TagFlowLayout parent, View view, int position) {
                Toast.makeText(mContext, "long click==" + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

            }
        });
        MyTagAdapter tagAdapter = new MyTagAdapter();
        tagAdapter.addAllTags(list);
        tagFlowLayout.setTagAdapter(tagAdapter);

    }

    class MyTagAdapter extends com.github.hymanme.tagflowlayout.TagAdapter<FaXianBean.DataBean.ListBean> {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DefaultTagView textView = new ColorfulTagView(mContext);
            textView.setText(list.get(position).getKeyword());
            return textView;
        }
    }


    /**
     * json解析数据
     *
     * @param json
     * @return
     */
    private FaXianBean paraseJson(String json) {

        FaXianBean netAudioBean = new Gson().fromJson(json, FaXianBean.class);
        return netAudioBean;
    }


    @OnClick({R.id.tv_main_faxian,  R.id.ll_xingqu, R.id.ll_huati, R.id.ic_scan_erweima,
            R.id.ll_huodong, R.id.ll_xiaoheiwu, R.id.ll_yuanchuang, R.id.ll_quanqu,
            R.id.ll_youxizhongxin, R.id.ll_zhoubian_shop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_main_faxian:
//                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
                SearchFragment searchFragment = SearchFragment.newInstance();
                searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
                    @Override
                    public void OnSearchClick(String keyword) {
                        //这里处理逻辑
                        Toast.makeText(mContext, keyword, Toast.LENGTH_SHORT).show();
                    }
                });
                searchFragment.show(getChildFragmentManager(), SearchFragment.TAG);
                break;
            case R.id.ic_scan_erweima:
                Intent intent0 = new Intent(mContext, CaptureActivity.class);
                startActivityForResult(intent0, REQUEST_CODE);
                break;
//            case R.id.flowlayout:
//                Toast.makeText(mContext, "都在搜", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.ll_xingqu:
//                Toast.makeText(mContext, "兴趣", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, InterestActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.ll_huati:
//                Toast.makeText(mContext, "话题", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(mContext, TopicActivity.class);
                mContext.startActivity(intent1);
                break;
            case R.id.ll_huodong:
//                Toast.makeText(mContext, "活动", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(mContext, TopicActivity.class);
                mContext.startActivity(intent2);
                break;
            case R.id.ll_xiaoheiwu:
                Toast.makeText(mContext, "小黑屋", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_yuanchuang:
//                Toast.makeText(mContext, "原创排行榜", Toast.LENGTH_SHORT).show();
                Intent inetnt4 = new Intent(mContext, OriginalRankActivity.class);
                mContext.startActivity(inetnt4);
                break;
            case R.id.ll_quanqu:
                Toast.makeText(mContext, "全区排行榜", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(mContext,DistrictActivity.class));
                break;
            case R.id.ll_youxizhongxin:
//                Toast.makeText(mContext, "游戏中心", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(mContext,MallActivity.class));
                break;
            case R.id.ll_zhoubian_shop:
//                Toast.makeText(mContext, "周边商城", Toast.LENGTH_SHORT).show();

                Intent intent5 = new Intent(mContext,MallWebViewActivity.class);
                mContext.startActivity(intent5);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(mContext, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(mContext, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }
}
