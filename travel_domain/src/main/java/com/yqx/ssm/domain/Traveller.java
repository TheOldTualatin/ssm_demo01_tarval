package com.yqx.ssm.domain;


public class Traveller {

  private String id;
  private String name;
  private String sex;
  private String phoneNum;
  private long credentialsType;
  private String credentialsNum;
  private long travellerType;


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


  public long getCredentialsType() {
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

  @Override
  public String toString()
  {
    return "Traveller{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", phoneNum='" + phoneNum + '\'' +
            ", credentialsType=" + credentialsType +
            ", credentialsNum='" + credentialsNum + '\'' +
            ", travellerType=" + travellerType +
            '}';
  }
}
