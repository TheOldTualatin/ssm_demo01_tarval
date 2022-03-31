package com.yqx.ssm.service;

import com.yqx.ssm.domain.Orders;

import java.util.List;

/**
 * @author YangQX   2022/3/16 - 11:18
 */
public interface IOrdersService
{
    /**
     * 查询所有订单
     * @param page 当前页数
     * @param size 煤业条数
     * @return 所有商品
     * @throws Exception
     */
    List<Orders> findAll(Integer page,Integer size) throws Exception;

    /**
     * 根据ID查询订单
     * @param id 所查询数据的ID
     * @throws Exception
     */
    Orders findById(String id) throws Exception;
}
