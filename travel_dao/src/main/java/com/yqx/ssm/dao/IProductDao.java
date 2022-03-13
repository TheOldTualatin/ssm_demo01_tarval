package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author YangQX   2022/3/12 - 9:31
 */
@Repository
public interface IProductDao
{
    /**
     * 查询所有商品
     * @return 查询到的商品列表
     * @throws Exception 查询失败
     */
    List<Product> findAll() throws Exception;
}
