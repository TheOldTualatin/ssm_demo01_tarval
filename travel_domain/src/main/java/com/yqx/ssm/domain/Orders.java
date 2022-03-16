package com.yqx.ssm.domain;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Orders {

  private String id;
  private String orderNum;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date orderTime;
  private long peopleCount;
  private String orderDesc;
  private long payType;
  private long orderStatus;
  private String productId;
  private String memberId;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(String orderNum) {
    this.orderNum = orderNum;
  }


  public Date getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(Date orderTime) {
    this.orderTime = orderTime;
  }


  public long getPeopleCount() {
    return peopleCount;
  }

  public void setPeopleCount(long peopleCount) {
    this.peopleCount = peopleCount;
  }


  public String getOrderDesc() {
    return orderDesc;
  }

  public void setOrderDesc(String orderDesc) {
    this.orderDesc = orderDesc;
  }


  public long getPayType() {
    return payType;
  }

  public void setPayType(long payType) {
    this.payType = payType;
  }


  public long getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(long orderStatus) {
    this.orderStatus = orderStatus;
  }


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

}
