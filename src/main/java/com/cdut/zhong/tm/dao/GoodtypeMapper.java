package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Goodtype;
import com.cdut.zhong.tm.bean.GoodtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodtypeMapper {
    long countByExample(GoodtypeExample example);

    int deleteByExample(GoodtypeExample example);

    int deleteByPrimaryKey(String name);

    int insert(Goodtype record);

    int insertSelective(Goodtype record);

    List<Goodtype> selectByExample(GoodtypeExample example);

    int updateByExampleSelective(@Param("record") Goodtype record, @Param("example") GoodtypeExample example);

    int updateByExample(@Param("record") Goodtype record, @Param("example") GoodtypeExample example);
}