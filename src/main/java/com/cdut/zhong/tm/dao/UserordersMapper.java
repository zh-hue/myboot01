package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Userorders;
import com.cdut.zhong.tm.bean.UserordersExample;
import java.util.List;

import com.cdut.zhong.tm.bean.OrderDetailBean;
import org.apache.ibatis.annotations.Param;

public interface UserordersMapper {
    long countByExample(UserordersExample example);

    int deleteByExample(UserordersExample example);

    int insert(Userorders record);

    int insertSelective(Userorders record);

    List<Userorders> selectByExample(UserordersExample example);

    List<OrderDetailBean> selectOrder(Integer userId);
    Userorders selectByKey(String orderCode);

    int updateByExampleSelective(@Param("record") Userorders record, @Param("example") UserordersExample example);

    int updateByExample(@Param("record") Userorders record, @Param("example") UserordersExample example);
}