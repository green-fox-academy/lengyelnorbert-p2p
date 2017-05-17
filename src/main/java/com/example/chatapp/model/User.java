package com.example.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "usertable")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long userID;
  private String userName;

  public User() {
  }

  public User(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public long getUserID() {
    return userID;
  }

  public void setUserID(long userID) {
    this.userID = userID;
  }
}
