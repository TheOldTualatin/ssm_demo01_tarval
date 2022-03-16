package com.yqx.ssm.service;

import com.yqx.ssm.domain.Orders;

import java.util.List;

/**
 * @author YangQX   2022/3/16 - 11:18
 */
public interface IOrdersService
{
    List<Orders> findAll() throws Exception;
}
