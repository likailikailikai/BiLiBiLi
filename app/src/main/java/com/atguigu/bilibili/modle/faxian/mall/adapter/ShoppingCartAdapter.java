package com.atguigu.bilibili.modle.faxian.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.bilibili.R;
import com.atguigu.bilibili.modle.faxian.mall.bean.ShopInfo;
import com.atguigu.bilibili.modle.faxian.mall.pay.AddSubView;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by admin on 2017/2/28.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder> {


    private final List<ShopInfo> datas;
    private final TextView tvShopcartTotal;
    private final CheckBox checkboxAll;
    private final CheckBox checkboxDeleteAll;
    private final Context mContext;


    public ShoppingCartAdapter(Context mContext, List<ShopInfo> list, TextView tvShopcartTotal, CheckBox checkboxAll, CheckBox checkboxDeleteAll) {
        this.mContext = mContext;
        this.datas = list;
        this.tvShopcartTotal = tvShopcartTotal;
        this.checkboxAll = checkboxAll;
        this.checkboxDeleteAll = checkboxDeleteAll;


    }


    public void showTotalPrice() {
        //显示总价格
        tvShopcartTotal.setText("合计：" + getTotalPric());
    }

    public double getTotalPric() {
        double totalPrice = 0;
        if (datas != null && datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                ShopInfo recordsBean = datas.get(i);
                if (recordsBean.getIsChecked()) {
                    totalPrice += recordsBean.getMoney() * recordsBean.getNumber();
                }
            }
        }
        return totalPrice;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new MyViewHolder(View.inflate(mContext, R.layout.item_shop_cart, null));
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //得到绑定数据
        final ShopInfo RecordsBean = datas.get(position);


        //绑定数据
        holder.cbGov.setChecked(RecordsBean.getIsChecked());

        //图片
        Glide.with(mContext).load(RecordsBean.getImageUrl()).into(holder.ivGov);


        //jiae
        holder.tvPriceGov.setText(RecordsBean.getMoney()+"");
        //设置名称
        holder.tvDescGov.setText(RecordsBean.getDetails());
        holder.addSubView.setValue(datas.get(position).getNumber());

        //设置数量
        holder.addSubView.setValue(RecordsBean.getNumber());

        holder.addSubView.setMinValue(1);

        holder.addSubView.setMaxvalue(100);

        holder.addSubView.setListener(new AddSubView.OnNumBerChangerListener() {
            @Override
            public void onNumberChanger(int value) {
                //回调数量
                RecordsBean.setNumber(value);

                showTotalPrice();
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    /**
     * 校验
  */
   public void checkAll() {
       if (datas != null && datas.size() > 0) {
           int number = 0;
           for (int i = 0; i < datas.size(); i++) {
               ShopInfo goodsBean = datas.get(i);
               if (!goodsBean.getIsChecked()) {
                   checkboxAll.setChecked(false);
                   checkboxDeleteAll.setChecked(false);
               } else {
                   number++;
               }
           }
           if (datas.size() == number) {
               checkboxAll.setChecked(true);
               checkboxDeleteAll.setChecked(true);
           }
       } else {
           checkboxAll.setChecked(false);
           checkboxDeleteAll.setChecked(false);
       }
   }


 /**
  * 删除数据
  *
  * @param
  */

   public void deleteData() {
       if (datas != null && datas.size() > 0) {
           for (int i = 0; i < datas.size(); i++) {
               ShopInfo goodsBean = datas.get(i);
               if (goodsBean.getIsChecked()) {
                   //内存中删除u
                   datas.remove(goodsBean);
                   //本地也保存
                   //刷新数据

                   notifyItemRemoved(i);
                   i--;
               }
           }
       }
   }


   public void checkAll_none(boolean isChecked) {
       if (datas != null && datas.size() > 0) {
           for (int i = 0; i < datas.size(); i++) {
               ShopInfo recordsBean = datas.get(i);
               recordsBean.setIsChecked(isChecked);
               checkboxAll.setChecked(isChecked);
               checkboxDeleteAll.setChecked(isChecked);

               //更新试图
               notifyItemChanged(i);
           }

       }

   }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.cb_gov)
        CheckBox cbGov;
        @InjectView(R.id.iv_gov)
        ImageView ivGov;
        @InjectView(R.id.tv_desc_gov)
        TextView tvDescGov;
        @InjectView(R.id.tv_price_gov)
        TextView tvPriceGov;
        @InjectView(R.id.addSubView)
        AddSubView  addSubView;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lisetener != null) {
                        lisetener.itemLisetener(v, getLayoutPosition());
                    }
                }
            });
        }
    }


    private setOnItemClickListener lisetener;

    public void setLisetener(setOnItemClickListener lisetener) {
        this.lisetener = lisetener;
    }

    public interface setOnItemClickListener {
        void itemLisetener(View view, int position);
    }

}
