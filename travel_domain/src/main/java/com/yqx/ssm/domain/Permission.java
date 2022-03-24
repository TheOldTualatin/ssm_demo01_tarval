package com.yqx.ssm.domain;


import java.util.List;

public class Permission {

  private String id;
  private String permissionName;
  private String url;
  private List<Permission> permissions;
  private List<UserInfo> users;

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getPermissionName()
  {
    return permissionName;
  }

  public void setPermissionName(String permissionName)
  {
    this.permissionName = permissionName;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public List<Permission> getPermissions()
  {
    return permissions;
  }

  public void setPermissions(List<Permission> permissions)
  {
    this.permissions = permissions;
  }

  public List<UserInfo> getUsers()
  {
    return users;
  }

  public void setUsers(List<UserInfo> users)
  {
    this.users = users;
  }

  @Override
  public String toString()
  {
    return "Permission{" +
            "id='" + id + '\'' +
            ", permissionName='" + permissionName + '\'' +
            ", url='" + url + '\'' +
            ", permissions=" + permissions +
            ", users=" + users +
            '}';
  }
}
