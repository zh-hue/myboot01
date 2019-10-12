package com.cdut.zhong.tm.controllers;

import com.cdut.zhong.tm.bean.Userinformation;
import com.cdut.zhong.tm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    //处理注册请求
    @RequestMapping("/register")
    public String register(){
        return "redirect:goToRegister";
    }

    @PostMapping("/registerNow")
    public String register(Userinformation userInformation, Map<String,String> map){
        String[] register = userService.register(userInformation);
        map.put("msg",register[1]);
        if (register[0] == "0"){
            return "register";
        }else {
            return "forward:/";
        }
    }

    @ResponseBody
    @PostMapping("/isrepeat")
    public boolean isrepeat(@RequestParam("username")String username){
       boolean repeat = userService.isRepeat(username);
       return repeat;
   }

    @ResponseBody
    @PostMapping("/enailIsUsed")
    public boolean emailIsUsed(@RequestParam("email")String email){
        boolean isUsed = userService.emailIsUsed(email);
        return isUsed;
    }
}
