package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.*;
import com.cdut.zhong.tm.dao.GoodsMapper;
import com.cdut.zhong.tm.dao.GoodsimginforMapper;
import com.cdut.zhong.tm.dao.GoodtypeMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService {

    @Resource
    GoodtypeMapper goodtypeMapper;
    @Resource
    GoodsMapper goodsMapper;
    @Resource
    GoodsimginforMapper goodsimginforMapper;

    //获取商品分类
    @Cacheable(cacheNames = {"haha"},key = "#root.methodName",cacheManager = "cacheManager")
    public List<Goodtype> getTypeList(){
        GoodtypeExample goodtypeExample = new GoodtypeExample();
        List<Goodtype> goodtypes = goodtypeMapper.selectByExample(goodtypeExample);
        return goodtypes;
    }

    //获取每个分类的商品
    @Cacheable(cacheNames = {"haha"},key = "#root.methodName",cacheManager = "cacheManager")
    public List<List<Goods>> getFLGoods(){
        List<List<Goods>> lists = new ArrayList<>();
        List<Goodtype> typeList = getTypeList();
        for (Goodtype list:typeList) {
            GoodsExample goodsExample = new GoodsExample();
            GoodsExample.Criteria criteria = goodsExample.createCriteria();
            criteria.andTypeEqualTo(list.getName());
            List<Goods> goods = goodsMapper.selectByExample(goodsExample);
            lists.add(goods);
        }
        return lists;
    }
    //获取商品对应分类
    public String getTypeByGoodsId(Integer id){
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        String type = goods.getType();
        return type;
    }

    //获取分类和4个商品图片简介等信息

    //加入商品
    public boolean insertGoods(Goods goods){
        int insert = goodsMapper.insert(goods);
        if (insert == 1){
            return true;
        }else {
            return false;
        }
    }

    //获取分类和前四个商品信息
    @Cacheable(cacheNames = {"haha"},key = "#root.methodName",cacheManager = "cacheManager")
    public List<List<Goodsimginfor>> zhanshi(){
        List<List<Goodsimginfor>> lists = new ArrayList<>();
        List<Goodtype> typeList = getTypeList();
        for (Goodtype list:typeList) {
            GoodsimginforExample goodsimginforExample = new GoodsimginforExample();
            GoodsimginforExample.Criteria criteria = goodsimginforExample.createCriteria();
            criteria.andTypeEqualTo(list.getName());
            List<Goodsimginfor> goodsimginfors = goodsimginforMapper.selectFourByExample(goodsimginforExample);
            lists.add(goodsimginfors);
        }
        return lists;
    }

    //获取商品图片url
    @Cacheable(cacheNames = {"imgBygoodsId"},key = "#id",cacheManager = "cacheManager")
    public String getGoodsUrl(Integer id){
        Goodsimginfor goodsimginfor = goodsimginforMapper.selectByKey(id);
        String imgurl = goodsimginfor.getImgurl();;
        return imgurl;
    }

}
