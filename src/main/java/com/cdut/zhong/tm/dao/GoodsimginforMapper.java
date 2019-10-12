package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Goodsimginfor;
import com.cdut.zhong.tm.bean.GoodsimginforExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsimginforMapper {
    long countByExample(GoodsimginforExample example);

    int deleteByExample(GoodsimginforExample example);

    int insert(Goodsimginfor record);

    int insertSelective(Goodsimginfor record);

    List<Goodsimginfor> selectByExample(GoodsimginforExample example);
    List<Goodsimginfor> selectFourByExample(GoodsimginforExample example);
    Goodsimginfor selectByKey(Integer id);

    int updateByExampleSelective(@Param("record") Goodsimginfor record, @Param("example") GoodsimginforExample example);

    int updateByExample(@Param("record") Goodsimginfor record, @Param("example") GoodsimginforExample example);
}