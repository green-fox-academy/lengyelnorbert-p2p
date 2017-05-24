package com.example.chatapp.model;


public class UniqueUser implements Comparable<UniqueUser> {

  private String uniqueUserName;

  public UniqueUser() {
  }

  public String getUniqueUserName() {
    return uniqueUserName;
  }

  public UniqueUser(String uniqueUserName) {
    this.uniqueUserName = uniqueUserName;
  }

  public void setUniqueUserName(String uniqueUserName) {
    this.uniqueUserName = uniqueUserName;
  }

  @Override
  public int compareTo(UniqueUser otherUniqueUser) {
    return (uniqueUserName.toLowerCase().compareTo(otherUniqueUser.getUniqueUserName().toLowerCase()));
  }
}
