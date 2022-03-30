package com.yqx.ssm.controller;

import com.yqx.ssm.config.UUIdUtils;
import com.yqx.ssm.domain.Product;
import com.yqx.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
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

    /**
     * 查询所有产品
     * @return 返回查询视图页面
     * @throws Exception 抛出异常
     */
    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN") //    方法级别的权限控制
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
     * 添加产品,注意从前端传递过来的日期格式的格式化
     * @param product 产品名称
     * @return 插入完成之后重新调用查询方法
     */
    @RequestMapping("/save.do")
    public String svae(Product product) throws Exception
    {
//        生成一个全球唯一的ID号
        String uuid = UUIdUtils.getId();
        product.setId(uuid);
        iProductService.save(product);
        return "redirect:/product/findAll.do";
    }
}
