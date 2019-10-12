package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.Userorders;
import com.cdut.zhong.tm.bean.UserordersExample;
import com.cdut.zhong.tm.dao.UserordersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class UserorderService {
    @Resource
    UserordersMapper orderMapper;

    //添加订单
    public boolean addOrder(Userorders order){
        int insert = orderMapper.insertSelective(order);
        if (insert == 1){
            return true;
        }else {
            return false;
        }
    }
    //查找订单
    public Userorders getOrderByCode(String code){
        Userorders userorders = orderMapper.selectByKey(code);
        return userorders;
    }
    //更新订单
    public boolean updateOrder(Userorders userorders){
        UserordersExample userordersExample = new UserordersExample();
        UserordersExample.Criteria criteria = userordersExample.createCriteria();
        criteria.andOrdercodeEqualTo(userorders.getOrdercode());
        int i = orderMapper.updateByExampleSelective(userorders, userordersExample);
        if (i==1){
            return true;
        }else{
            return false;
        }
    }

    //删除订单
    public boolean deleteOrder(Integer userId,String orderCode){
        UserordersExample userordersExample = new UserordersExample();
        UserordersExample.Criteria criteria = userordersExample.createCriteria();
        criteria.andOrdercodeEqualTo(orderCode);
        criteria.andIdEqualTo(userId);
        int i = orderMapper.deleteByExample(userordersExample);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }
}
