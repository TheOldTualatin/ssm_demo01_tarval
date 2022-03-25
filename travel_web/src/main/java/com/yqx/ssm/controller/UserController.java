package com.yqx.ssm.controller;

import com.yqx.ssm.domain.UserInfo;
import com.yqx.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author YangQX   2022/3/25 - 17:21
 */
@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll()
    {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = iUserService.findAll();
        modelAndView.addObject("userList",userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)
    {
        System.out.println("id= "+ id);
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = iUserService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }
}
