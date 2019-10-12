package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Userheadportrait;
import com.cdut.zhong.tm.bean.UserheadportraitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserheadportraitMapper {
    long countByExample(UserheadportraitExample example);

    int deleteByExample(UserheadportraitExample example);

    int insert(Userheadportrait record);

    int insertSelective(Userheadportrait record);

    List<Userheadportrait> selectByExample(UserheadportraitExample example);

    int updateByExampleSelective(@Param("record") Userheadportrait record, @Param("example") UserheadportraitExample example);

    int updateByExample(@Param("record") Userheadportrait record, @Param("example") UserheadportraitExample example);
}