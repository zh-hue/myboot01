package com.cdut.zhong.tm;

import com.cdut.zhong.tm.bean.Goods;
//import com.cdut.zhong.tm.bean.Goodsimginfor;
//import com.cdut.zhong.tm.service.IndexService;
import com.cdut.zhong.tm.service.UserOrderDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmApplicationTests {
//    @Resource
//    IndexService service;
//    @Resource
//    UserOrderDetailService userOrderDetailService;

    @Test
    public void contextLoads() throws Exception {
//        userOrderDetailService.getOrderDetails(1);
//        for (int i = 9;i<45;i+=4){
//            for (int j = i;j < i+4;j++){
//                Goodsimginfor goods = new Goodsimginfor();
//                if (i <13){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("太阳镜");
//                    goods.setType("太阳镜");
//                    goods.setPrice(500);
//                }
//                else if (i < 17){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("女表");
//                    goods.setType("女表");
//                    goods.setPrice(500);
//                }
//                else if (i < 21){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("冰箱");
//                    goods.setType("冰箱");
//                    goods.setPrice(500);
//                }
//                else if (i <25){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("时尚男鞋");
//                    goods.setType("时尚男鞋");
//                    goods.setPrice(500);
//                }
//                else if (i < 29){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("电热水器");
//                    goods.setType("电热水器");
//                    goods.setPrice(500);
//                }
//                else if (i < 33){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("男士西服");
//                    goods.setType("男士西服");
//                    goods.setPrice(500);
//                }
//                else if (i < 37){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("男表");
//                    goods.setType("男表");
//                    goods.setPrice(500);
//                }
//                else if (i < 41){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("空调");
//                    goods.setType("空调");
//                    goods.setPrice(500);
//                }
//                else if (i < 45){
//                    goods.setId(j);
//                    goods.setImgurl("E:\\天猫网站\\商品图片\\"+j+".jpg");
//                    goods.setInformation("马桶");
//                    goods.setType("马桶");
//                    goods.setPrice(500);
//                }
//                service.insertinf(goods);
//            }
//        }
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("mybatis-gen.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
    }

}
