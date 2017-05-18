package com.example.chatapp.model;


public class FrontEndMessages {

  static String userNameFieldIsEmpty = "The username field is empty";
  static String standardFrontEndText = "";
  static String frontEndMessageToShow;

  public static String getUserNameFieldIsEmpty() {
    return userNameFieldIsEmpty;
  }

  public static void setUserNameFieldIsEmpty(String userNameFieldIsEmpty) {
    FrontEndMessages.userNameFieldIsEmpty = userNameFieldIsEmpty;
  }

  public static String getStandardFrontEndText() {
    return standardFrontEndText;
  }

  public static void setStandardFrontEndText(String standardFrontEndText) {
    FrontEndMessages.standardFrontEndText = standardFrontEndText;
  }

  public static String getFrontEndMessageToShow() {
    return frontEndMessageToShow;
  }

  public static void setFrontEndMessageToShow(String frontEndMessageToShow) {
    FrontEndMessages.frontEndMessageToShow = frontEndMessageToShow;
  }
}
