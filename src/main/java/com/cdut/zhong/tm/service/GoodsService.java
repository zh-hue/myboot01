package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.Goods;
import com.cdut.zhong.tm.bean.GoodsBaseInformation;
import com.cdut.zhong.tm.bean.GoodsExample;
import com.cdut.zhong.tm.dao.GoodsMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    public GoodsBaseInformation getBaseInformation(Integer id){
        GoodsBaseInformation baseInformation = goodsMapper.selectByGoodsKey(id);
        return baseInformation;
    }

    //库存
    public boolean updateStack(Integer num,Integer userid){
        Goods goods = new Goods();
        goods.setId(userid);
        Goods goods1 = goodsMapper.selectByPrimaryKey(userid);
        Integer stock = goods1.getStock();
        if (stock >= num){
            goods.setStock(stock-num);
            int i = goodsMapper.updateByPrimaryKeySelective(goods);
            if (i == 1){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    //获取商品信息
    @Cacheable(cacheNames = {"haha"},key = "#root.methodName",cacheManager = "cacheManager")
    public Goods getShoppingGoods(Integer goodsId){
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        return goods;
    }

    //批量获取商品信息
//    @Cacheable(cacheNames = {"haha"},key = "'shoppingcar'",cacheManager = "cacheManager")
    public List<Goods> getShoppingGoods(List<Integer> goodsIds){
        System.out.println("------");
        List<Goods> goodsList = new ArrayList<>();
        for (Integer goodsId : goodsIds){
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            goodsList.add(goods);
        }
        return goodsList;
    }
}
