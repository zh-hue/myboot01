package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.CommentFormBean;
import com.cdut.zhong.tm.bean.Goodsevaluate;
import com.cdut.zhong.tm.bean.Userinformation;
import com.cdut.zhong.tm.service.CommentService;
import com.cdut.zhong.tm.service.GoodsService;
import com.cdut.zhong.tm.service.GoodsevaluateService;
import com.cdut.zhong.tm.service.IndexService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Controller
public class CommentController {

    @Resource
    IndexService indexService;

    @Resource
    CommentService commentService;

    @Resource
    GoodsevaluateService goodsevaluateService;

    @PostMapping("/goToComment")
    public String getComment(CommentFormBean formBean,HttpSession session, Map<String,Object>map) throws ParseException {
        System.out.println(formBean.getDateString());
        Userinformation user = (Userinformation)session.getAttribute("user");
        formBean.setId(user.getId());//评论用户
        Date dad = new Date(formBean.getDateString());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dad);
        calendar.add(Calendar.HOUR_OF_DAY,-12);
        dad = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(dad);
        formBean.setDateString(format);//评论时间
        int sevaluateCountById = goodsevaluateService.getSevaluateCountById(formBean.getGoodsid());
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        map.put("commentMsg",formBean);
        map.put("commentNum",sevaluateCountById);
        return "commentHtml";
    }

    //添加评论
    @PostMapping("/addComment")
    public String addComment(Goodsevaluate goodsevaluate,HttpSession session, Map<String,Object>map){
        Userinformation user = (Userinformation)session.getAttribute("user");
        Integer id = user.getId();
        goodsevaluate.setUserid(id);
        goodsevaluate.setEvaluatetime(new Date());
        String typeByGoodsId = indexService.getTypeByGoodsId(goodsevaluate.getId());
        commentService.addComment(goodsevaluate);
        map.put("type",typeByGoodsId);
        map.put("goodsid",goodsevaluate.getId());
        return "forward:/gooddetailHtml";
    }
}
