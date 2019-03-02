package com.bwie.android.zyaozhong0302.bean;

public class OrderInfoBean {
    private String commodityId;
    private int amount;

    public OrderInfoBean(String commodityId, int amount) {
        this.commodityId = commodityId;
        this.amount = amount;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
