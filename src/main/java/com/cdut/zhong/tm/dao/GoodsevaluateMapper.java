package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Goodsevaluate;
import com.cdut.zhong.tm.bean.GoodsevaluateExample;
import java.util.List;

import com.cdut.zhong.tm.bean.SevaluateBean;
import org.apache.ibatis.annotations.Param;

public interface GoodsevaluateMapper {
    long countByExample(GoodsevaluateExample example);

    int deleteByExample(GoodsevaluateExample example);

    int insert(Goodsevaluate record);

    int insertSelective(Goodsevaluate record);

    List<Goodsevaluate> selectByExample(GoodsevaluateExample example);
    List<SevaluateBean> selectByGoodsId(Integer id);

    int updateByExampleSelective(@Param("record") Goodsevaluate record, @Param("example") GoodsevaluateExample example);

    int updateByExample(@Param("record") Goodsevaluate record, @Param("example") GoodsevaluateExample example);
}