package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.OrderDetailBean;
import com.cdut.zhong.tm.dao.UserordersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserOrderDetailService {
    @Resource
    UserordersMapper userordersMapper;
    public List<OrderDetailBean>  getOrderDetails(Integer userid){
        List<OrderDetailBean> orderDetailBeans = userordersMapper.selectOrder(userid);
        return orderDetailBeans;
    }
}
