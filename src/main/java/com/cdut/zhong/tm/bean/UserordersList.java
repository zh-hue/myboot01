package com.cdut.zhong.tm.bean;

import java.util.List;

public class UserordersList {
    private List<Userorders> list;

    public List<Userorders> getList() {
        return list;
    }

    public void setList(List<Userorders> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserordersList{" +
                "list=" + list +
                '}';
    }
}
