package com.cdut.zhong.tm.bean;

public class Goodsimginfor {
    private Integer id;

    private String imgurl;

    private String information;

    private String type;

    private Integer price;

    private Integer dealnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information == null ? null : information.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDealnum() {
        return dealnum;
    }

    public void setDealnum(Integer dealnum) {
        this.dealnum = dealnum;
    }

    @Override
    public String toString() {
        return "Goodsimginfor{" +
                "id=" + id +
                ", imgurl='" + imgurl + '\'' +
                ", information='" + information + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", dealnum=" + dealnum +
                '}';
    }
}