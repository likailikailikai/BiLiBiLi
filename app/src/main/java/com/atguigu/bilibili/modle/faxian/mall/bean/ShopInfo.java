package com.atguigu.bilibili.modle.faxian.mall.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by admin on 2017/3/28.
 */
@Entity
public class ShopInfo {
    @Id
    private Long id;
    private String imageUrl;
    private String details;
    private int money;
    private int number = 1;
    private boolean isChecked = true;

    public boolean getIsChecked() {
        return this.isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 583952770)
    public ShopInfo(Long id, String imageUrl, String details, int money,
                    int number, boolean isChecked) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.details = details;
        this.money = money;
        this.number = number;
        this.isChecked = isChecked;
    }

    @Generated(hash = 1227838148)
    public ShopInfo() {
    }


}
