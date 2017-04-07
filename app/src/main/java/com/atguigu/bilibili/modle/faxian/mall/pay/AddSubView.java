package com.atguigu.bilibili.modle.faxian.mall.pay;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.bilibili.R;


/**
 * Created by admin on 2017/3/28.
 */

public class AddSubView extends LinearLayout {

    private ImageView iv_sub;
    private  ImageView iv_add;
    private TextView tv_value;

    private int minValue =1;
    private  int value =1;
    private  int maxvalue= 10;



    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        tv_value.setText(value+"");
    }

    public int getMaxvalue() {
        return maxvalue;
    }

    public void setMaxvalue(int maxvalue) {
        this.maxvalue = maxvalue;
    }

    public AddSubView(Context context, AttributeSet attrs) {
        super(context, attrs);

         View.inflate(context, R.layout.add_sub_view,AddSubView.this);
         iv_sub = (ImageView)findViewById(R.id.iv_sub);
         iv_add = (ImageView)findViewById(R.id.iv_add);
         tv_value = (TextView)findViewById(R.id.tv_value);
        //設置點擊事件
        iv_sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value>minValue) {
                    value --;
                }
                setValue(value);
                if(listener !=null) {
                    listener.onNumberChanger(value);
                }
            }
        });

        iv_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value<maxvalue) {
                    value++;
                }
                setValue(value);
                if(listener !=null) {
                    listener.onNumberChanger(value);
                }
            }
        });

        if (attrs != null) {
            //取出属性
            TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.AddSubView);
            int value = tintTypedArray.getInt(R.styleable.AddSubView_value, 0);
            if (value > 0) {
                setValue(value);
            }
            int minValue = tintTypedArray.getInt(R.styleable.AddSubView_minValue, 0);
            if (value > 0) {
                setMinValue(minValue);
            }
            int maxValue = tintTypedArray.getInt(R.styleable.AddSubView_maxValue, 0);
            if (value > 0) {
                setMaxvalue(maxValue);
            }
            Drawable addDrawable = tintTypedArray.getDrawable(R.styleable.AddSubView_numberAddBackground);
            if (addDrawable != null) {
                iv_add.setImageDrawable(addDrawable);
            }
            Drawable subDrawable = tintTypedArray.getDrawable(R.styleable.AddSubView_numberSubBackground);
            if (subDrawable != null) {
                iv_sub.setImageDrawable(subDrawable);
            }
        }

    }


    /*定義接口*/
    public  interface  OnNumBerChangerListener{
        public  void onNumberChanger(int value);
    }

    private OnNumBerChangerListener listener;

    public void setListener(OnNumBerChangerListener listener) {
        this.listener = listener;
    }
}
