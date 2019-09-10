package com.example.user.pojo;


public class User {

  private long id;
  private String userName;
  private String password;
  private String telephone;
  private String email;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp newLoginTime;
  private long state;
  private String invitationCode;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getNewLoginTime() {
    return newLoginTime;
  }

  public void setNewLoginTime(java.sql.Timestamp newLoginTime) {
    this.newLoginTime = newLoginTime;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public String getInvitationCode() {
    return invitationCode;
  }

  public void setInvitationCode(String invitationCode) {
    this.invitationCode = invitationCode;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", telephone='" + telephone + '\'' +
            ", email='" + email + '\'' +
            ", createTime=" + createTime +
            ", newLoginTime=" + newLoginTime +
            ", state=" + state +
            ", invitationCode='" + invitationCode + '\'' +
            '}';
  }
}
