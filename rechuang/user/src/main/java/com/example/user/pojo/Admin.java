package com.example.user.pojo;


import java.util.Date;

public class Admin {

  private long id;
  private String adminName;
  private String password;
  private Date createTime;
  private Date newLoginTime;
  private long state;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getNewLoginTime() {
    return newLoginTime;
  }

  public void setNewLoginTime(Date newLoginTime) {
    this.newLoginTime = newLoginTime;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "Admin{" +
            "id=" + id +
            ", adminName='" + adminName + '\'' +
            ", password='" + password + '\'' +
            ", createTime=" + createTime +
            ", newLoginTime=" + newLoginTime +
            ", state=" + state +
            '}';
  }
}
