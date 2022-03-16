package com.yqx.ssm.controller;

import com.yqx.ssm.domain.Orders;
import com.yqx.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author YangQX   2022/3/16 - 11:22
 */
@Controller
@RequestMapping("/orders")
public class OrdersController
{
    @Autowired
    private IOrdersService iOrdersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception
    {
        ModelAndView mv = new ModelAndView();
        List<Orders> all = iOrdersService.findAll();
        mv.addObject("",all);
        mv.setViewName("orders-list");
        return mv;
    }
}
