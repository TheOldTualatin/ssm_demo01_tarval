package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Orders;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author YangQX   2022/3/16 - 11:12
 */
@Repository
public interface IOrdersDao
{
    @Select("select * from order")
    List<Orders> findAll() throws Exception;
}
