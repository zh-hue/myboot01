package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.Goods;
import com.cdut.zhong.tm.bean.Goodsimginfor;
import com.cdut.zhong.tm.bean.Userinformation;
import com.cdut.zhong.tm.service.IndexService;
import com.cdut.zhong.tm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    UserService userService;
    @Resource
    IndexService indexService;

    //处理登录请求
    @RequestMapping("/login")
    public String login(Userinformation userInformation, HttpSession session, Map<String,Object> map){//RedirectAttributes attributes添加重定向参数
        Userinformation userInformation1 = userService.userIsExist(userInformation);
        if (userInformation1 == null){
            map.put("msg","账号或密码错误!");
            //回到登录页面
            return "login";
        }else {
            //添加session
            session.setAttribute("user",userInformation1);
            //转发到个人中心页面处理器
            return "redirect:/goToIndex";
        }
    }

    //处理成功请求,去到个人中心页面(此时以经过过滤器)
    @RequestMapping("/goToIndex")
    public String goToPersonHtml(HttpSession session,Map<String,Object>map){
        Userinformation user = (Userinformation)session.getAttribute("user");
        map.put("username",user.getUsername());
        map.put("email",user.getEmail());
        map.put("userid",user.getId());
        map.put("typeList",indexService.getTypeList());
        List<List<Goods>> flGoods = indexService.getFLGoods();
        map.put("flGoods",flGoods);
        List<List<Goodsimginfor>> zhanshi = indexService.zhanshi();
        map.put("zhanshi",zhanshi);
        return "index";
    }
}
