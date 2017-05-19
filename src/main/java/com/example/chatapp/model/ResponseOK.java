package com.example.chatapp.model;

public class ResponseOK implements ResponseObject {

  private String status = "ok";

  public ResponseOK() {
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
