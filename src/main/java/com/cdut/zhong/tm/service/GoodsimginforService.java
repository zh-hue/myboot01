package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.Goodsimginfor;
import com.cdut.zhong.tm.bean.GoodsimginforExample;
import com.cdut.zhong.tm.dao.GoodsimginforMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsimginforService {

    @Resource
    GoodsimginforMapper goodsimginforMapper;

    //获取记录数
    public long getCount(){
        long l = goodsimginforMapper.countByExample(new GoodsimginforExample());
        return l;
    }

    //添加数据
    public boolean addGoodsimginfor(Goodsimginfor goodsimginfor){
        int insert = goodsimginforMapper.insert(goodsimginfor);
        if (insert == 1){
            return true;
        }else {
            return false;
        }
    }

    //获取分类下的所有商品
    @Cacheable(cacheNames = {"haha"},key = "#root.methodName+#orderBy",cacheManager = "cacheManager")
    public List<Goodsimginfor> getGoodsimginfor(String type,String orderBy){
        GoodsimginforExample goodsimginforExample = new GoodsimginforExample();
        goodsimginforExample.setOrderByClause(orderBy);
        GoodsimginforExample.Criteria criteria = goodsimginforExample.createCriteria();
        criteria.andTypeEqualTo(type);
        List<Goodsimginfor> goodsimginfors = goodsimginforMapper.selectByExample(goodsimginforExample);
        return goodsimginfors;
    }

    //修改销量
    public boolean updateDealnum(Integer num,Integer goodsid){
        GoodsimginforExample goodsimginforExample = new GoodsimginforExample();
        GoodsimginforExample.Criteria criteria = goodsimginforExample.createCriteria();
        criteria.andIdEqualTo(goodsid);
        Goodsimginfor goodsimginfor1 = goodsimginforMapper.selectByKey(goodsid);
        Integer dealnum = goodsimginfor1.getDealnum();
        Goodsimginfor goodsimginfor = new Goodsimginfor();
        goodsimginfor.setDealnum(dealnum+num);
        int i = goodsimginforMapper.updateByExampleSelective(goodsimginfor, goodsimginforExample);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }
}
