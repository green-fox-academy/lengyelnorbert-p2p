package com.example.chatapp.model;


public class TransferMessage {

  ChatMessage message;
  Client client;

  public TransferMessage() {
  }

  public ChatMessage getMessage() {
    return message;
  }

  public void setMessage(ChatMessage message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
