package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Member;
import com.yqx.ssm.domain.Orders;
import com.yqx.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YangQX   2022/3/16 - 11:12
 */
@Repository
public interface IOrdersDao
{
    /**
     * Associated query of multiple tables
     * @return the order object
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
//            The subquery,specify that the type to be queried is an object，Then the associated query method
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yqx.ssm.dao.IProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yqx.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.yqx.ssm.dao.IMember.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.yqx.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId);
}
