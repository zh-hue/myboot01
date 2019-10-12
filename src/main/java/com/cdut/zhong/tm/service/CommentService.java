package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.Goodsevaluate;
import com.cdut.zhong.tm.dao.GoodsevaluateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentService {

    @Resource
    GoodsevaluateMapper goodsevaluateMapper;

    //添加评论
    public boolean addComment(Goodsevaluate goodsevaluate){
        int insert = goodsevaluateMapper.insert(goodsevaluate);
        if (insert == 1){
            return true;
        }else {
            return false;
        }
    }
}
