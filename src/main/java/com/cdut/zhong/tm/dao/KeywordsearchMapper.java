package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Keywordsearch;
import com.cdut.zhong.tm.bean.KeywordsearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordsearchMapper {
    long countByExample(KeywordsearchExample example);

    int deleteByExample(KeywordsearchExample example);

    int insert(Keywordsearch record);

    int insertSelective(Keywordsearch record);

    List<Keywordsearch> selectByExample(KeywordsearchExample example);
    List<Integer> selectGoodsIdByExample(KeywordsearchExample example);

    int updateByExampleSelective(@Param("record") Keywordsearch record, @Param("example") KeywordsearchExample example);

    int updateByExample(@Param("record") Keywordsearch record, @Param("example") KeywordsearchExample example);
}