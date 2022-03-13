package com.yqx.ssm.service;

import com.yqx.ssm.domain.Product;

import java.util.List;

/**
 * @author YangQX   2022/3/12 - 9:35
 */
public interface IProductService
{
    List<Product> finAll() throws Exception;
}
