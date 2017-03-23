package com.sunkang.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

/**
 * Created by changxiang on 2017-03-17.
 * 登录
 */
@Controller
public class LoginController {

    /**
     * 设置默认页面为home页面
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView toHome(){
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("menu","ROLE_ADMIN");
        modelAndView.addObject("username",getPrincipal());
        return modelAndView;
    }

    /**
     * 自定义登录界面
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }

    /**
     * 跳转到主界面
     * @return
     */
   @RequestMapping(value = "/home")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("menu","ROLE_ADMIN");
        modelAndView.addObject("username",getPrincipal());
        return modelAndView;
    }

    /**
     * 获得登录的用户
     * @return
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
