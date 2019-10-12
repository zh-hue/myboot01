package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.Shoppingcar;
import com.cdut.zhong.tm.bean.ShoppingcarExample;
import com.cdut.zhong.tm.dao.ShoppingcarMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingCarService {

    @Resource
    ShoppingcarMapper shoppingcarMapper;

    //获取对应用户的选购商品
    public List<Integer> getUserCar(Integer userId){
        ShoppingcarExample shoppingcarExample = new ShoppingcarExample();
        ShoppingcarExample.Criteria criteria = shoppingcarExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<Integer> shoppingcarGoods = shoppingcarMapper.selectGoodsIdByExample(shoppingcarExample);
        return shoppingcarGoods;
    }

    public boolean isExist(Shoppingcar shoppingcar){
        ShoppingcarExample shoppingcarExample = new ShoppingcarExample();
        ShoppingcarExample.Criteria criteria = shoppingcarExample.createCriteria();
        criteria.andGoodsidEqualTo(shoppingcar.getGoodsid());
        criteria.andUseridEqualTo(shoppingcar.getUserid());
        List<Shoppingcar> shoppingcars = shoppingcarMapper.selectByExample(shoppingcarExample);
        if (shoppingcars.size()>0){
            return true;
        }else {
            return false;
        }
    }

    //添加商品到购物车
    public boolean addGoodsToCar(Shoppingcar shoppingcar){
        int insert = shoppingcarMapper.insert(shoppingcar);
        if (insert == 1){
            return true;
        }else {
            return false;
        }
    }

    //从购物车删除商品
//    @CachePut(cacheNames = {"haha"},key = "'shoppingcar'",cacheManager = "cacheManager")
    public boolean deleteFromShoppingCar(Shoppingcar shoppingcar){
        ShoppingcarExample shoppingcarExample = new ShoppingcarExample();
        ShoppingcarExample.Criteria criteria = shoppingcarExample.createCriteria();
        criteria.andUseridEqualTo(shoppingcar.getUserid());
        criteria.andGoodsidEqualTo(shoppingcar.getGoodsid());
        int i = shoppingcarMapper.deleteByExample(shoppingcarExample);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }
}
