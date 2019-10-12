package com.cdut.zhong.tm.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDetailBean {
    private Integer id;

    private String ordercode;

    private Integer goodsid;

    private String name;

    private Integer price;

    private Integer goodsnum;

    private String orderstate;

    private Integer allprice;

    private String href;

    private Date placedate;

    private String dateString;

    private String stateClass;

    private Map<String,Object> patterns;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
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

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public Integer getAllprice() {
        return allprice;
    }

    public void setAllprice(Integer allprice) {
        this.allprice = allprice;
    }

    public Date getPlacedate() {
        return placedate;
    }

    public void setPlacedate(Date placedate) {
        this.placedate = placedate;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public Map<String, Object> getPatterns() {
        return patterns;
    }

    public void setPatterns(Map<String, Object> patterns) {
        this.patterns = patterns;
    }

    public String getStateClass() {
        return stateClass;
    }

    public void setStateClass(String stateClass) {
        this.stateClass = stateClass;
    }

    @Override
    public String toString() {
        return "OrderDetailBean{" +
                "id=" + id +
                ", ordercode='" + ordercode + '\'' +
                ", goodsid=" + goodsid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", goodsnum=" + goodsnum +
                ", orderstate='" + orderstate + '\'' +
                ", allprice=" + allprice +
                ", href='" + href + '\'' +
                ", placedate=" + placedate +
                ", dateString='" + dateString + '\'' +
                ", stateClass='" + stateClass + '\'' +
                '}';
    }
}
