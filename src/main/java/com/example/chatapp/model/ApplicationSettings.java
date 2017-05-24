package com.example.chatapp.model;


public class ApplicationSettings {

  private static String CHAT_APP_PEER_ADDRESSS = "https://dorinagychatapp.herokuapp.com/api/message/receive";
  private static String CHAT_APP_UNIQUE_ID = "https://lengyelnorbert.herokuapp.com/";

  public static String getChatAppPeerAddresss() {
    return CHAT_APP_PEER_ADDRESSS;
  }

  public static String getChatAppUniqueId() {
    return CHAT_APP_UNIQUE_ID;
  }
}
