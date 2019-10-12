package com.cdut.zhong.tm.bean;

public class Userheadportrait {
    private Integer id;

    private String headportraiturl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadportraiturl() {
        return headportraiturl;
    }

    public void setHeadportraiturl(String headportraiturl) {
        this.headportraiturl = headportraiturl == null ? null : headportraiturl.trim();
    }
}