package com.example.chatapp.model;


import org.springframework.stereotype.Component;

@Component
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

  @Override
  public String toString() {
    return "TransferMessage{" +
            "message=" + message +
            ", client=" + client +
            '}';
  }
}
