package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.Goods;
import com.cdut.zhong.tm.bean.ListGoodsClass;
import com.cdut.zhong.tm.bean.Shoppingcar;
import com.cdut.zhong.tm.bean.Userinformation;
import com.cdut.zhong.tm.service.GoodsService;
import com.cdut.zhong.tm.service.ShoppingCarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCarController {
    @Resource
    ShoppingCarService service;

    @Resource
    GoodsService goodsService;

    //前往购物车页面
    @RequestMapping("/goToShoppingCar")
    public String goToShopping(HttpSession session, Map<String,Object> map){
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        //获取选购商品
        List<Integer> userCar = service.getUserCar(user.getId());
        //获取商品信息
        List<Goods> shoppingGoods = goodsService.getShoppingGoods(userCar);
        map.put("shoppingGoods",shoppingGoods);
        return "shoppingCarHtml";
    }

    //添加商品到购物车
    @PostMapping("/addShoppingCar")
    @ResponseBody
    public String addShoppingToCar(HttpSession session,@RequestParam("goodsId")Integer goodsId){
        Userinformation user = (Userinformation)session.getAttribute("user");
        Shoppingcar shoppingcar = new Shoppingcar();
        shoppingcar.setUserid(user.getId());
        shoppingcar.setGoodsid(goodsId);
        boolean exist = service.isExist(shoppingcar);
        if (exist){
            return "商品已在购物车中!";
        }else {
            boolean b = service.addGoodsToCar(shoppingcar);
            if (b){
                return "添加成功!";
            }else {
                return "添加失败!";
            }
        }
    }

    //删除购物车商品
    @PostMapping("/deleteShoppingCar")
    @ResponseBody
    public String deleteShoppingCar(HttpSession session,@RequestParam("goodsId")Integer goodsId){
        Userinformation user = (Userinformation)session.getAttribute("user");
        Shoppingcar shoppingcar = new Shoppingcar();
        shoppingcar.setUserid(user.getId());
        shoppingcar.setGoodsid(goodsId);
        boolean success = service.deleteFromShoppingCar(shoppingcar);
        if (success){
            return "删除成功!";
        }else {
            return "删除失败!";
        }
    }
}
