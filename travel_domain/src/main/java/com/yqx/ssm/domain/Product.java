package com.yqx.ssm.domain;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Product
{

    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    /**
     * 前端传递的数据必须经过格式化转化为Date对象，并且填入的占位符也要与前端传递的时间格式一致
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private long productPrice;
    private String productDesc;
    private int productStatus;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getProductNum()
    {
        return productNum;
    }

    public void setProductNum(String productNum)
    {
        this.productNum = productNum;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public Date getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime)
    {
        this.departureTime = departureTime;
    }

    public long getProductPrice()
    {
        return productPrice;
    }

    public void setProductPrice(long productPrice)
    {
        this.productPrice = productPrice;
    }

    public String getProductDesc()
    {
        return productDesc;
    }

    public void setProductDesc(String productDesc)
    {
        this.productDesc = productDesc;
    }

    public int getProductStatus()
    {
        return productStatus;
    }

    public void setProductStatus(int productStatus)
    {
        this.productStatus = productStatus;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                '}';
    }
}
