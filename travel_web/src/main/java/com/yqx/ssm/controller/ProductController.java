package com.yqx.ssm.controller;

import com.yqx.ssm.domain.Product;
import com.yqx.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author YangQX   2022/3/12 - 10:11
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private IProductService iProductService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception
    {
        ModelAndView mv = new ModelAndView();
        List<Product> products = iProductService.finAll();
        System.out.println(products.toString());
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }
}
