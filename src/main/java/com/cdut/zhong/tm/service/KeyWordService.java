package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.Goodsimginfor;
import com.cdut.zhong.tm.bean.Keywordsearch;
import com.cdut.zhong.tm.bean.KeywordsearchExample;
import com.cdut.zhong.tm.dao.GoodsimginforMapper;
import com.cdut.zhong.tm.dao.KeywordsearchMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class KeyWordService {
    @Resource
    KeywordsearchMapper keywordsearchMapper;
    @Resource
    GoodsimginforMapper goodsimginforMapper;

    public List<Goodsimginfor> getGoddsinf(String string){

        List<Goodsimginfor> result = new ArrayList<>();
        KeywordsearchExample example = new KeywordsearchExample();
        KeywordsearchExample.Criteria criteria = example.createCriteria();
        criteria.andKeywordEqualTo(string);
        List<Integer> goodsIds = keywordsearchMapper.selectGoodsIdByExample(example);
        for (Integer goodsId:goodsIds){
            Goodsimginfor goodsimginfor = goodsimginforMapper.selectByKey(goodsId);
            result.add(goodsimginfor);
        }
        return result;
    }
}
