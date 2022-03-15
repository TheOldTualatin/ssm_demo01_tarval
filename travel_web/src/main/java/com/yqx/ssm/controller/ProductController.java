package com.yqx.ssm.controller;

import com.yqx.ssm.domain.Product;
import com.yqx.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

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

    /**
     * 查询所有产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception
    {
        ModelAndView mv = new ModelAndView();
        List<Product> products = iProductService.finAll();
        System.out.println(products.toString());
        mv.addObject("productList",products);
//        请求转发跳转,这样可以避开视图解析器添加的WEB-INF的前路径
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 添加产品
     * @param product 产品名称
     * @return 插入完成之后重新调用查询方法
     */
    @RequestMapping("/save.do")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public String svae(Product product) throws Exception
    {
//        生成一个全球唯一的ID号
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        product.setId(uuid.toString());
        iProductService.save(product);
        return "redirect:/product/findAll.do";
    }
}
