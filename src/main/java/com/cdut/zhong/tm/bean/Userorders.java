package com.cdut.zhong.tm.bean;

import java.util.Date;

public class Userorders {
    private Integer id;

    private String ordercode;

    private Integer goodsid;

    private String receiveaddress;

    private String receiveusermsg;

    private String zipcode;

    private String userphone;

    private Date placedate;

    private Date deliverdate;

    private Date paymentdate;

    private Date receivingdate;

    private String orderstate;

    private String userremarks;

    private Integer goodsnum;

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
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress == null ? null : receiveaddress.trim();
    }

    public String getReceiveusermsg() {
        return receiveusermsg;
    }

    public void setReceiveusermsg(String receiveusermsg) {
        this.receiveusermsg = receiveusermsg == null ? null : receiveusermsg.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public Date getPlacedate() {
        return placedate;
    }

    public void setPlacedate(Date placedate) {
        this.placedate = placedate;
    }

    public Date getDeliverdate() {
        return deliverdate;
    }

    public void setDeliverdate(Date deliverdate) {
        this.deliverdate = deliverdate;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public Date getReceivingdate() {
        return receivingdate;
    }

    public void setReceivingdate(Date receivingdate) {
        this.receivingdate = receivingdate;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate == null ? null : orderstate.trim();
    }

    public String getUserremarks() {
        return userremarks;
    }

    public void setUserremarks(String userremarks) {
        this.userremarks = userremarks == null ? null : userremarks.trim();
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }
}