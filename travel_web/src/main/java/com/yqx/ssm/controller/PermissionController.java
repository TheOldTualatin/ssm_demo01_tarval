package com.yqx.ssm.controller;

import com.yqx.ssm.config.UUIdUtils;
import com.yqx.ssm.domain.Permission;
import com.yqx.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author YangQX   2022/3/28 - 18:00
 */
@Controller
@RequestMapping("/permission")
public class PermissionController
{
    @Autowired
    IPermissionService iPermissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception
    {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions = iPermissionService.findAll();
        modelAndView.addObject("permissions",permissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception
    {
        permission.setId(UUIdUtils.getId());
        iPermissionService.save(permission);
        return "redirect:/permission/findAll.do";
    }
}
