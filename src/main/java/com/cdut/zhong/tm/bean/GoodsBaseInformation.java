package com.cdut.zhong.tm.bean;

public class GoodsBaseInformation {
    private String name;

    private Integer stock;

    private Integer price;

    private String information;

    private Integer dealnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getDealnum() {
        return dealnum;
    }

    public void setDealnum(Integer dealnum) {
        this.dealnum = dealnum;
    }

    @Override
    public String toString() {
        return "GoodsBaseInformation{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", information='" + information + '\'' +
                ", dealnum=" + dealnum +
                '}';
    }
}
