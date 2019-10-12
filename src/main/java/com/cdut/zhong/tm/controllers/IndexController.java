package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.Goods;
import com.cdut.zhong.tm.bean.Goodsimginfor;
import com.cdut.zhong.tm.bean.Goodtype;
import com.cdut.zhong.tm.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Resource
    IndexService indexService;

    @RequestMapping("/")
    public String getGoodList(Map<String,Object> map){
        return "login";
    }

    @RequestMapping("/img")
    @ResponseBody
    public void getImg(@RequestParam("id")Integer id, HttpServletResponse response){
        String goodsUrl = indexService.getGoodsUrl(id);
        ServletOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = response.getOutputStream();
            fileInputStream = new FileInputStream(goodsUrl);
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/DetailImg")
    @ResponseBody
    public void getDetailImg(@RequestParam("prefix")String prefix, HttpServletResponse response){
        String format = String.format("E:\\天猫网站\\商品五样式图片\\%s.jpg", prefix);
        ServletOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = response.getOutputStream();
            fileInputStream = new FileInputStream(format);
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
