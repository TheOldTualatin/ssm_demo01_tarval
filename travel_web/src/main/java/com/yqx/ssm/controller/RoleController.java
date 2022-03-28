package com.yqx.ssm.controller;

import com.yqx.ssm.domain.Role;
import com.yqx.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author YangQX   2022/3/28 - 17:37
 */
@Controller
@RequestMapping("/role")
public class RoleController
{
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = iRoleService.findAll();
        modelAndView.addObject("roleList",roles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
