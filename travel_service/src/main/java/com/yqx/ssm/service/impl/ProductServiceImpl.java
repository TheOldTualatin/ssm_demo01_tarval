package com.yqx.ssm.service.impl;

import com.yqx.ssm.dao.IProductDao;
import com.yqx.ssm.domain.Product;
import com.yqx.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author YangQX   2022/3/12 - 9:37
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService
{
    /**
     * 自动装配到Dao层
     */
    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> finAll() throws Exception
    {
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception
    {
        iProductDao.save(product);
    }
}
