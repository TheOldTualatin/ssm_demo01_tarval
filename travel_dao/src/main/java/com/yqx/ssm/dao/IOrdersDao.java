package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Orders;
import com.yqx.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
//            The subquery,specify that the type to be queried is an object，Then the associated query method
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.yqx.ssm.dao.IProductDao.findById")),
            @Result(property = "orderNum",column = "orderNum"),
    })
    List<Orders> findAll() throws Exception;
}
