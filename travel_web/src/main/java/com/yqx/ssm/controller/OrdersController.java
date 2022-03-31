package com.yqx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.yqx.ssm.domain.Orders;
import com.yqx.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 查询全部订单未分页
     * @return
     * @throws Exception
     */
//    @RequestMapping("/findAll")
//    public ModelAndView findAll() throws Exception
//    {
//        ModelAndView mv = new ModelAndView();
//        List<Orders> all = iOrdersService.findAll();
//        mv.addObject("ordersList",all);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    /**
     * 分页查询所有订单
     *
     * @param page 当前页码
     * @param size 每页显示的条数
     * @return 视图
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = true, defaultValue = "3") Integer size
                               ) throws Exception
    {
        ModelAndView mv = new ModelAndView();
        List<Orders> all = iOrdersService.findAll(page, size);
//        pageInfo就是一个分页的bean,里面存储了分页相关的数据
        PageInfo pageInfo = new PageInfo(all);
        for (Object item : pageInfo.getList())
        {
            Orders orders = (Orders) item;
            System.out.println(orders);
        }
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception
    {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(id);
        Orders orders = iOrdersService.findById(id);
        System.out.println(orders);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

    ;
}
