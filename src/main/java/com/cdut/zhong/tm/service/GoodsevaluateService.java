package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.GoodsevaluateExample;
import com.cdut.zhong.tm.bean.SevaluateBean;
import com.cdut.zhong.tm.dao.GoodsevaluateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsevaluateService {
    @Resource
    GoodsevaluateMapper goodsevaluateMapper;
    //获取数据记录数目
    public long getCount(Integer id){
        GoodsevaluateExample goodsevaluateExample = new GoodsevaluateExample();
        GoodsevaluateExample.Criteria criteria = goodsevaluateExample.createCriteria();
        criteria.andIdEqualTo(id);
        long l = goodsevaluateMapper.countByExample(goodsevaluateExample);
        return l;
    }
    //根据商品id返回记录
    public List<SevaluateBean> getSevaluateById(Integer id){
        List<SevaluateBean> sevaluateBeans = goodsevaluateMapper.selectByGoodsId(id);
        return sevaluateBeans;
    }

    //返回某商品记录数
    public int getSevaluateCountById(Integer id){
        List<SevaluateBean> sevaluateBeans = goodsevaluateMapper.selectByGoodsId(id);
        return sevaluateBeans.size();
    }
}
