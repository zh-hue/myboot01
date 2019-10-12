package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.*;
import com.cdut.zhong.tm.service.GoodsService;
import com.cdut.zhong.tm.service.GoodsimginforService;
import com.cdut.zhong.tm.service.ShoppingCarService;
import com.cdut.zhong.tm.service.UserorderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class OrderController {
    @Resource
    UserorderService orderService;
    @Resource
    GoodsService service;
    @Resource
    GoodsimginforService goodsimginforService;
    @Resource
    ShoppingCarService shoppingCarService;

    //前往订单页面
    @RequestMapping(value = "/goToOrderHtml",method = RequestMethod.POST)
    public String goToOrderHtml(@RequestParam("allPrice")Integer allPrice,
                                ListGoodsClass goodsClass, @RequestParam(value = "isShoppingCar",required = false)String isShoppingCar,
                                Map<String,Object>map, HttpSession session){
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        map.put("goodsLists",goodsClass.getList());
        map.put("allPrice",allPrice);
        map.put("isShoppingCar",isShoppingCar);
        return "orderHtml";
    }

    @PostMapping("/goToListPlayHtml")
    public String goToListPlay(UserordersList orderLists,
                               @RequestParam("allPrice")Integer allPrice,@RequestParam(value = "isShoppingCar",required = false)String isShoppingCar,
                               Map<String,Object> map,
                               HttpSession session){
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        map.put("allPrice",allPrice);

        List<String> list = new ArrayList<>();
        List<Integer> goodsLists = new ArrayList<>();
        for (Userorders order:orderLists.getList()) {
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int millisecond = calendar.get(Calendar.MILLISECOND);
            String code = String.format(""+year+month+day+hour+minute+millisecond+user.getId()+order.getGoodsid());
            order.setOrdercode(code);
            order.setPlacedate(date);
            order.setId(user.getId());
            order.setOrderstate("待支付");
            list.add(code);
            goodsLists.add(order.getGoodsid());
            boolean b = orderService.addOrder(order);
            //修改库存
            boolean b1 = service.updateStack(order.getGoodsnum(),order.getGoodsid());
            goodsimginforService.updateDealnum(order.getGoodsnum(),order.getGoodsid());
            map.put("address",order.getReceiveaddress());
        }
        map.put("orderLists",list);
        map.put("goodsLists",goodsLists);
        map.put("isShoppingCar",isShoppingCar);
        return "palyHtml";
    }

    //直接前往支付页面
    @PostMapping("/goToPlay")
    public String goToPlay(@RequestParam("allPrice") Integer allPrice,@RequestParam("orderCode") String orderCode,
                           @RequestParam("goodsid")Integer goodsid, Map<String,Object> map,HttpSession session){
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        map.put("allPrice",allPrice);
        List<String> list = new ArrayList<>();
        list.add(orderCode);
        map.put("orderLists",list);
        return "palyHtml";
    }

    @PostMapping("/playSuccessHtml")
    public String goToPlaySuccessHtml(@RequestParam("allPrice") Integer allPrice,@RequestParam(value = "isShoppingCar",required = false)String isShoppingCar,
                                      CodeStringList codeStringList,//问题
                                      Map<String,Object> map,
                                      HttpSession session){
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        map.put("allPrice",allPrice);
        for (String str:codeStringList.getList()) {
            Userorders orderByCode = orderService.getOrderByCode(str);
            orderByCode.setOrderstate("待发货");
            orderByCode.setPaymentdate(new Date());
            boolean b = orderService.updateOrder(orderByCode);
        }
        Integer id = user.getId();
        //清除购物车(判断是购物车清单?)
        if (isShoppingCar!=null){
            List<Integer> goodsList = codeStringList.getGoodsList();
            for (Integer goodsId:goodsList) {
                Shoppingcar shoppingcar = new Shoppingcar();
                shoppingcar.setUserid(id);
                shoppingcar.setGoodsid(goodsId);
                shoppingCarService.deleteFromShoppingCar(shoppingcar);
            }
        }
        return "playSuccessHtml";
    }

    @PostMapping("/updateOrder")
    @ResponseBody
    public void updateOrder(@RequestParam("code") String code,@RequestParam("state") String state){
        Userorders orderByCode = orderService.getOrderByCode(code);
        orderByCode.setOrderstate(state);
        if (state.equals("待收货")){
            orderByCode.setDeliverdate(new Date());
        }else if (state.equals("评价")){
            orderByCode.setReceivingdate(new Date());
        }
        boolean b = orderService.updateOrder(orderByCode);
    }

    @PostMapping("/deleteOrderAjax")
    @ResponseBody
    public String deleteOrderFunc(HttpSession session,@RequestParam("orderCode") String orderCode){
        Userinformation user = (Userinformation)session.getAttribute("user");
        Integer id = user.getId();
        boolean b = orderService.deleteOrder(id, orderCode);
        if (b){
            return "删除成功!";
        }else {
            return "删除失败!";
        }
    }
}
