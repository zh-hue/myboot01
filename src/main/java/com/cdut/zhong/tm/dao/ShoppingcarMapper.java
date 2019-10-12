package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Shoppingcar;
import com.cdut.zhong.tm.bean.ShoppingcarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoppingcarMapper {
    long countByExample(ShoppingcarExample example);

    int deleteByExample(ShoppingcarExample example);

    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);

    List<Shoppingcar> selectByExample(ShoppingcarExample example);
    List<Integer> selectGoodsIdByExample(ShoppingcarExample example);

    int updateByExampleSelective(@Param("record") Shoppingcar record, @Param("example") ShoppingcarExample example);

    int updateByExample(@Param("record") Shoppingcar record, @Param("example") ShoppingcarExample example);
}