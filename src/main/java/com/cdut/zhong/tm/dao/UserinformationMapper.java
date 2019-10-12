package com.cdut.zhong.tm.dao;

import com.cdut.zhong.tm.bean.Userinformation;
import com.cdut.zhong.tm.bean.UserinformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinformationMapper {
    long countByExample(UserinformationExample example);

    int deleteByExample(UserinformationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userinformation record);

    int insertSelective(Userinformation record);

    List<Userinformation> selectByExample(UserinformationExample example);

    Userinformation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userinformation record, @Param("example") UserinformationExample example);

    int updateByExample(@Param("record") Userinformation record, @Param("example") UserinformationExample example);

    int updateByPrimaryKeySelective(Userinformation record);

    int updateByPrimaryKey(Userinformation record);
}