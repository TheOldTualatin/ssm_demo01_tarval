package com.yqx.ssm.domain;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class Orders {

  private String id;
  private String orderNum;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date orderTime;
  private long peopleCount;
  private String orderDesc;
  private long payType;
  private String payTypeStr;
  private Product product;
  private String memberId;
  private Member member;
  private List<Traveller> travellers;
  private long orderStatus;
  private String orderStatusStr;

  public String getPayTypeStr()
  {
    if(payType==0)
    {
      return "微信支付";
    }else
    {
      return "支付宝支付";
    }
  }

  public void setPayTypeStr(String payTypeStr)
  {
    this.payTypeStr = payTypeStr;
  }

  public void setOrderStatusStr(String orderStatusStr)
  {
    this.orderStatusStr = orderStatusStr;
  }

  public String getOrderStatusStr()
  {
    if(orderStatus==0)
    {
      return "已支付";
    }
    else
    {
      return "未支付";
    }
  }



  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getOrderNum()
  {
    return orderNum;
  }

  public void setOrderNum(String orderNum)
  {
    this.orderNum = orderNum;
  }

  public Date getOrderTime()
  {
    return orderTime;
  }

  public void setOrderTime(Date orderTime)
  {
    this.orderTime = orderTime;
  }

  public long getPeopleCount()
  {
    return peopleCount;
  }

  public void setPeopleCount(long peopleCount)
  {
    this.peopleCount = peopleCount;
  }

  public String getOrderDesc()
  {
    return orderDesc;
  }

  public void setOrderDesc(String orderDesc)
  {
    this.orderDesc = orderDesc;
  }

  public long getPayType()
  {
    return payType;
  }

  public void setPayType(long payType)
  {
    this.payType = payType;
  }

  public long getOrderStatus()
  {
    return orderStatus;
  }

  public void setOrderStatus(long orderStatus)
  {
    this.orderStatus = orderStatus;
  }

  public Product getProduct()
  {
    return product;
  }

  public void setProduct(Product product)
  {
    this.product = product;
  }

  public String getMemberId()
  {
    return memberId;
  }

  public void setMemberId(String memberId)
  {
    this.memberId = memberId;
  }

  public List<Traveller> getTravellers()
  {
    return travellers;
  }

  public void setTravellers(List<Traveller> travellers)
  {
    this.travellers = travellers;
  }

  public Member getMember()
  {
    return member;
  }

  public void setMember(Member member)
  {
    this.member = member;
  }

  @Override
  public String toString()
  {
    return "Orders{" +
            "id='" + id + '\'' +
            ", orderNum='" + orderNum + '\'' +
            ", orderTime=" + orderTime +
            ", peopleCount=" + peopleCount +
            ", orderDesc='" + orderDesc + '\'' +
            ", payType=" + payType +
            ", payTypeStr='" + payTypeStr + '\'' +
            ", product=" + product +
            ", memberId='" + memberId + '\'' +
            ", member=" + member +
            ", travellers=" + travellers +
            ", orderStatus=" + orderStatus +
            ", orderStatusStr='" + orderStatusStr + '\'' +
            '}';
  }
}
