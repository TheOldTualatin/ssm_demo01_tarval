package com.yqx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.yqx.ssm.dao.IOrdersDao;
import com.yqx.ssm.domain.Orders;
import com.yqx.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangQX   2022/3/16 - 11:19
 */
@Service
public class OrdersServiceImpl implements IOrdersService
{
    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll() throws Exception
    {
//        指定分页参数,pageNum是页码值，pageSize是每一页显示的条数
        PageHelper.startPage(1,5);
        return iOrdersDao.findAll();
    }
}
