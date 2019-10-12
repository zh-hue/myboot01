package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.*;
import com.cdut.zhong.tm.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@Controller
public class GoodsController {
    @Resource
    GoodsimginforService goodsimginforService;
    @Resource
    IndexService indexService;
    @Resource
    GoodsevaluateService goodsevaluateService;
    @Resource
    GoodsService goodsService;
    @Resource
    KeyWordService keyWordService;

    //查询商品集合，展示
    @PostMapping("/goodsByKeyword")
    public String gotogoodsByKeyword(@RequestParam("keywords")String keywords, HttpSession session, Map<String,Object> map){
        //返回商品分类信息
        List<Goodsimginfor> goodsimginfors = keyWordService.getGoddsinf(keywords);
        List<List<Object>> lists = new ArrayList<>();
        for (Goodsimginfor good :goodsimginfors){
            long count = goodsevaluateService.getCount(good.getId());
            List<Object> list = new ArrayList<>();
            list.add(count);
            list.add(good);
            lists.add(list);
        }
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("lists",lists);
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());

        return "searchHtml";
    }


    @PostMapping("/goods")
    public String gotogoods(@RequestParam("type")String type,
                            HttpSession session,
                            @RequestParam(value = "orderby",defaultValue = "price asc")String orderby,
                            Map<String,Object> map){
        //返回商品分类信息
        List<Goodsimginfor> goodsimginfors = goodsimginforService.getGoodsimginfor(type,orderby);

        List<List<Object>> lists = new ArrayList<>();
        for (Goodsimginfor good :goodsimginfors){
            long count = goodsevaluateService.getCount(good.getId());
            List<Object> list = new ArrayList<>();
            list.add(count);
            list.add(good);
            lists.add(list);
        }
        Userinformation user = (Userinformation)session.getAttribute("user");

        map.put("lists",lists);
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());

        map.put("type",goodsimginfors.get(0).getType());

        return "goodshtml";
    }

    //对于ajax请求响应
    @RequestMapping("/goodsAjax")
    @ResponseBody
    public  List<List<Object>> gotogoodsAjax(@RequestParam("type")String type,@RequestParam(value = "orderby",defaultValue = "price asc")String orderby,Map<String,Object> map){
        //返回商品分类信息
        List<Goodsimginfor> goodsimginfors = goodsimginforService.getGoodsimginfor(type,orderby);
        List<List<Object>> lists = new ArrayList<>();
        for (Goodsimginfor good :goodsimginfors){
            long count = goodsevaluateService.getCount(good.getId());
            List<Object> list = new ArrayList<>();
            list.add(count);
            list.add(good);
            lists.add(list);
        }
        return lists;
    }

    @RequestMapping("/addHtml")
    public String gotoaddHtml(){
        return "addHtml";
    }

    //添加商品
    @PostMapping("/addGoods")
    @ResponseBody
    public String addGoods(@RequestParam("name") String name,
                           @RequestParam("stock") String stock,
                           @RequestParam("type") String type,
                           @RequestParam("price") String price,
                           @RequestParam("imgurl")MultipartFile file,
                           @RequestParam("information") String information){
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            long count = goodsimginforService.getCount();
            String format = String.format("E:\\天猫网站\\商品图片\\%d.jpg", count + 1);
            inputStream = file.getInputStream();
            fileOutputStream = new FileOutputStream(format);

            int priceint = Integer.parseInt(price);
            int stockint = Integer.parseInt(stock);
            //构建goods
            Goods goods = new Goods();
            goods.setType(type);
            goods.setStock(stockint);
            goods.setName(name);
            goods.setPrice(priceint);
            //构建Goodsimginfor
            //查看当前有多少记录，决定图片id
            Goodsimginfor goodsimginfor = new Goodsimginfor();
            goodsimginfor.setPrice(priceint);
            goodsimginfor.setType(type);
            goodsimginfor.setInformation(information);
            goodsimginfor.setImgurl(format);
            boolean b = indexService.insertGoods(goods);
            if (!b){
                return "添加失败!";
            }
            boolean b1 = goodsimginforService.addGoodsimginfor(goodsimginfor);
            if (!b1){
                return "添加失败!";
            }
            byte[] bytes = new byte[(int) file.getSize()];
            inputStream.read(bytes);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            return "成功!";
        }catch(Exception e){
            System.out.println(e.toString());
            return "出现错误，检查库存和价格是否为整数!";
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //商品详细页面
    @PostMapping("/gooddetailHtml")
    public String goTogooddetailHtml(@RequestParam(value = "id")Integer id, HttpSession session, Map<String,Object> map,@RequestParam(value = "issuccess",required = false)Integer issuccess){
        GoodsBaseInformation baseInformation = goodsService.getBaseInformation(id);
        List<SevaluateBean> sevaluateByIds = goodsevaluateService.getSevaluateById(id);
        for (SevaluateBean sevaluateBean:sevaluateByIds) {
            Date evaluatetime = sevaluateBean.getEvaluatetime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = formatter.format(evaluatetime);
            sevaluateBean.setDateString(format);
        }
        long sevaluates = goodsevaluateService.getCount(id);
        Userinformation user = (Userinformation)session.getAttribute("user");
        String typeByGoodsId = indexService.getTypeByGoodsId(id);
        map.put("goodsid",id);
        map.put("type",typeByGoodsId);
        map.put("num",sevaluates);
        map.put("baseInformation",baseInformation);
        map.put("sevaluateByIds",sevaluateByIds);
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        if (issuccess != null){
            map.put("issuccess",issuccess);
        }
        return "gooddetailHtml";
    }


}
