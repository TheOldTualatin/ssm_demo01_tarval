package com.yqx.ssm.domain;


public class Traveller {

  private String id;
  private String name;
  private String sex;
  private String phoneNum;
  private Long credentialsType;
  private String credentialsTypeStr;
  private String credentialsNum;
  private Long travellerType;
  private String travellerTypeStr;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }


  public Long getCredentialsType() {
    if(credentialsType!=null)
    {
      if(credentialsType==0)
      {
         credentialsTypeStr = "身份证";
      }else  if(credentialsType==1)
      {
        credentialsTypeStr = "护照";
      }else  if(credentialsType==2)
      {
        credentialsTypeStr = "军官证";
      }
    }
    return credentialsType;
  }

  public void setCredentialsType(long credentialsType) {
    this.credentialsType = credentialsType;
  }


  public String getCredentialsNum() {
    return credentialsNum;
  }

  public void setCredentialsNum(String credentialsNum) {
    this.credentialsNum = credentialsNum;
  }


  public long getTravellerType() {
    return travellerType;
  }

  public void setTravellerType(long travellerType) {
    this.travellerType = travellerType;
  }

  public void setCredentialsType(Long credentialsType)
  {
    this.credentialsType = credentialsType;
  }

  public String getCredentialsTypeStr()
  {
    return credentialsTypeStr;
  }

  public void setCredentialsTypeStr(String credentialsTypeStr)
  {
    this.credentialsTypeStr = credentialsTypeStr;
  }

  public void setTravellerType(Long travellerType)
  {
    this.travellerType = travellerType;
  }

  public String getTravellerTypeStr()
  {
    if(travellerType!=null)
    {
      if(travellerType==0)
      {
        travellerTypeStr = "成人";
      }else  if(travellerType==1)
      {
        travellerTypeStr = "儿童";
      }
    }
    return travellerTypeStr;
  }

  public void setTravellerTypeStr(String travellerTypeStr)
  {
    this.travellerTypeStr = travellerTypeStr;
  }

  @Override
  public String toString()
  {
    return "Traveller{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", phoneNum='" + phoneNum + '\'' +
            ", credentialsType=" + credentialsType +
            ", credentialsTypeStr='" + credentialsTypeStr + '\'' +
            ", credentialsNum='" + credentialsNum + '\'' +
            ", travellerType=" + travellerType +
            ", travellerTypeStr=" + travellerTypeStr +
            '}';
  }
}
