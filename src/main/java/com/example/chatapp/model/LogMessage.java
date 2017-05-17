package com.example.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class LogMessage {
  private String path;
  private String method;
  private String dateAndTime;
  private String logLevel;
  private String requestData;

  public LogMessage() {
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMehtod() {
    return method;
  }

  public void setMehtod(String mehtod) {
    this.method = mehtod;
  }

  public String getDateAndTime() {
    return dateAndTime;
  }

  public void setDateAndTime(String dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }


}

