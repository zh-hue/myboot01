package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.OrderDetailBean;
import com.cdut.zhong.tm.bean.Userinformation;
import com.cdut.zhong.tm.service.UserOrderDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderDetailController {
    @Resource
    UserOrderDetailService userOrderDetailService;

    @RequestMapping("/OrderDetailHtml")
    public String goToOrderDetail(Map<String,Object>map, HttpSession session){
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        List<OrderDetailBean> orderDetails = userOrderDetailService.getOrderDetails(user.getId());
        map.put("orderDetails",orderDetails);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (OrderDetailBean orderDetailBean:orderDetails) {
            String orderstate1 = orderDetailBean.getOrderstate();
            if (orderstate1.equals("待支付")){
                orderDetailBean.setStateClass("waitPay");
            }
            if (orderstate1.equals("待发货")){
                orderDetailBean.setStateClass("waitDelivery");
            }
            if (orderstate1.equals("待收货")){
                orderDetailBean.setStateClass("waitConfirm");
            }
            if (orderstate1.equals("评价")){
                orderDetailBean.setStateClass("waitReview");
            }
            String format = formatter.format(orderDetailBean.getPlacedate());
            orderDetailBean.setDateString(format);
            String orderstate = orderDetailBean.getOrderstate();
            Integer allprice = orderDetailBean.getAllprice();
            String ordercode = orderDetailBean.getOrdercode();
            Integer goodsid = orderDetailBean.getGoodsid();
            Map<String,Object> map1 = new HashMap<>();
            map1.put("allPrice",allprice);
            map1.put("orderCode",ordercode);
            map1.put("goodsid",goodsid);
            orderDetailBean.setPatterns(map1);
            if (orderstate.equals("待支付")){
                orderDetailBean.setHref("/goToPlay");
            }else if (orderstate.equals("待发货")){
                orderDetailBean.setHref("#");
            }else if (orderstate.equals("待确认")){
                orderDetailBean.setHref("#");
            }else if (orderstate.equals("评价")){
                orderDetailBean.setHref("/goToComment");
            }
        }
        return "orderDetailHtml";
    }

}
