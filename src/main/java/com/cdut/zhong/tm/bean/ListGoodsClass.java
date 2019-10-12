package com.cdut.zhong.tm.bean;

import java.util.List;

public class ListGoodsClass {
    private List<Goods> list;


    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListGoodsClass{" +
                "list=" + list +
                '}';
    }
}
