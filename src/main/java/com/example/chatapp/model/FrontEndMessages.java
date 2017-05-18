package com.example.chatapp.model;


public class FrontEndMessages {

  static String frontEndMessageToShow = "Welcome";

  public static String getFrontEndMessageToShow() {
    return frontEndMessageToShow;
  }

  public static void setFrontEndMessageToShow(String frontEndMessageToShow) {
    FrontEndMessages.frontEndMessageToShow = frontEndMessageToShow;
  }
}
