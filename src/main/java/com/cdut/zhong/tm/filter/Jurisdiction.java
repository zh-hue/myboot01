package com.cdut.zhong.tm.filter;

import com.cdut.zhong.tm.bean.Userinformation;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Jurisdiction implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        HttpSession session = request.getSession();
        Userinformation user = (Userinformation)session.getAttribute("user");
        if (user == null){
            request.setAttribute("msg","没有权限请先登录!");
            request.getRequestDispatcher("/").forward(request,response);
        }else {
            filterChain.doFilter(request,response);
        }
    }
}
