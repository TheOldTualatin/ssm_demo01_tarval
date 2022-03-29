package com.yqx.ssm.controller;

import com.yqx.ssm.config.UUIdUtils;
import com.yqx.ssm.domain.Role;
import com.yqx.ssm.domain.UserInfo;
import com.yqx.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView findAll() throws Exception
    {
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfoList = iUserService.findAll();
        modelAndView.addObject("userList",userInfoList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception
    {
        System.out.println("id= "+ id);
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = iUserService.findById(id);
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception
    {
        userInfo.setId(UUIdUtils.getId());
        iUserService.save(userInfo);
//        添加完成后再次查看所有用户
        return "redirect:/user/findAll.do";
    }

    /**
     * 查询用户以及查询用户可以添加的角色信息
     * @param userId 用户ID
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String userId) throws Exception
    {
//        1.根据用户Id查询用户信息
        ModelAndView modelAndView = new ModelAndView();
        UserInfo user = iUserService.findById(userId);
        List<Role> roleList = iUserService.findOtherRoles(userId);
        modelAndView.addObject("user",user);
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-role-add");
        return  modelAndView;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name="userId",required = true) String userId,
                                @RequestParam(name = "ids",required = true) String[] ids) throws Exception
    {
        iUserService.addRoleToUser(userId,ids);
        return "redirect:/user/findAll.do";
    }
}
