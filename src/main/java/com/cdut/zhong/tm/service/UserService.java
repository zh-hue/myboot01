package com.cdut.zhong.tm.service;

import com.cdut.zhong.tm.bean.Userinformation;
import com.cdut.zhong.tm.bean.UserinformationExample;
import com.cdut.zhong.tm.dao.UserinformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Resource
    UserinformationMapper userinformationMapper;

    public Userinformation getUser(Integer id){
        Userinformation information = userinformationMapper.selectByPrimaryKey(id);
        return information;
    }

    //判断用户是否存在
    public Userinformation userIsExist(Userinformation userInformation){
        if (userInformation == null){
            return null;
        }
        UserinformationExample userInformationExample = new UserinformationExample();
        UserinformationExample.Criteria criteria = userInformationExample.createCriteria();
        criteria.andUsernameEqualTo(userInformation.getUsername());
        criteria.andPasswordEqualTo(userInformation.getPassword());
        List<Userinformation> userInformations = userinformationMapper.selectByExample(userInformationExample);
        if (userInformations.size()>0){
            return userInformations.get(0);
        }else {
            return null;
        }
    }

    //名字是否重复
    public boolean isRepeat(String name){
        UserinformationExample userExample = new UserinformationExample();
        UserinformationExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<Userinformation> users = userinformationMapper.selectByExample(userExample);
        if (users.size()>0){
            return true;
        }else {
            return false;
        }
    }

    //名字是否符合规范:字母，中文 2-8长度
    public boolean userNameIsStandard(String name){
        Pattern compile = Pattern.compile("[a-zA-Z\\u4e00-\\u9fa5]{2,8}");
        Matcher matcher = compile.matcher(name);
        boolean matches = matcher.matches();
        return matches;
    }

    //密码是否规范(必须包含数字,字母,长度6-10)
    public boolean pswIsStandard(String password){
        Pattern compile = Pattern.compile("(?!^[a-zA-Z]+$)(?!^[0-9]+$)^[0-9a-zA-Z]{6,10}$");
        Matcher matcher = compile.matcher(password);
        boolean matches = matcher.matches();
        return matches;
    }

    //电子邮件是否规范:用户名@域名.com
    public boolean emailIsStandard(String email){
        Pattern compile = Pattern.compile("[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.com");
        Matcher matcher = compile.matcher(email);
        boolean matches = matcher.matches();
        return matches;
    }

    //电子邮件是否已经被使用
    public boolean emailIsUsed(String email){
        UserinformationExample userExample = new UserinformationExample();
        UserinformationExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        List<Userinformation> users = userinformationMapper.selectByExample(userExample);
        if (users.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    //用户是否可以注册
    public String[] isPossibleToRegister(Userinformation user){
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String[] results = new String[2];
        if (username == null || username.replaceAll(" ","").equals("")){
            results[0] = "0";
            results[1] = "用户名不能为空!";
            return results;
        }
        if (password == null || password.replaceAll(" ","").equals("")){
            results[0] = "0";
            results[1] = "密码不能为空!";
            return results;
        }
        if (email == null || email.replaceAll(" ","").equals("")){
            results[0] = "0";
            results[1] = "电子邮件不能为空!";
            return results;
        }
        if (!userNameIsStandard(username)){
            results[0] = "0";
            results[1] = "用户名不合法,由2-8个英文字母或汉字组成";
            return results;
        }else if (!emailIsStandard(email)){
            results[0] = "0";
            results[1] = "电子邮件不合法!";
            return results;
        }else if (!pswIsStandard(password)){
            results[0] = "0";
            results[1] = "密码不合法!,必须包含数字,字母,长度为6-10";
            return results;
        }else if (isRepeat(username)){
            results[0] = "0";
            results[1] = "用户名已经被使用";
            return results;
        }else if (emailIsUsed(email)){
            results[0] = "0";
            results[1] = "一个电子邮件只能注册一个账号!";
            return results;
        }else {
            int insert = userinformationMapper.insert(user);
            if (insert ==1){
                results[0] = "1";
                results[1] = "注册成功,请登录!";
                return results;
            }else {
                results[0] = "0";
                results[1] = "用户验证正确,但注册时失败!";
                return results;
            }
        }
    }

    //注册用户
    public String[] register(Userinformation user){
        String[] possibleToRegister = isPossibleToRegister(user);
        return possibleToRegister;
    }
}
