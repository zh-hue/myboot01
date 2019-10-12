package com.cdut.zhong.tm.bean;

import java.util.Date;

public class CommentFormBean {

    private Integer id;

    private String name;

    private Integer price;

    private Date placetime;

    private Integer goodsid;

    private String dateString;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPlacetime() {
        return placetime;
    }

    public void setPlacetime(Date placetime) {
        this.placetime = placetime;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public String toString() {
        return "CommentFormBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", placetime=" + placetime +
                ", goodsid=" + goodsid +
                ", dateString='" + dateString + '\'' +
                '}';
    }
}
