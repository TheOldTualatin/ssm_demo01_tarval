package com.yqx.ssm.dao;

import com.yqx.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
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
    @Select("select * from ssm_test.product")
    List<Product> findAll() throws Exception;

    /**
     * add product
     * @param product The product object
     * @throws Exception
     */
    @Insert("insert into ssm_test.product(id,productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) values(#{id},#{productNum}, #{productName}, #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    void save(Product product) throws Exception;

    /**
     * Query products by
     *
     * @return The product object
     */
    @Select("select * from product where id =#{id}")
    Product findById(String id);

}
