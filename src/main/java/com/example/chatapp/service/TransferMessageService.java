package com.example.chatapp.service;

import com.example.chatapp.model.ApplicationSettings;
import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.model.Client;
import com.example.chatapp.model.ResponseMessage;
import com.example.chatapp.model.TransferMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransferMessageService {

  @Autowired
  TransferMessage transferMessage;

  @Autowired
  UserService userService;

  @Autowired
  Client client;

  RestTemplate restTemplate;

  public TransferMessageService() {
    restTemplate = new RestTemplate();
  }

  public void transferOwnMessage(ChatMessage chatMessage) {
    transferMessage.setMessage(chatMessage);
    client.setId(userService.getActiveUser().getUserName());
    transferMessage.setClient(client);
    broadcast(transferMessage);
  }

  public void transferOtherMessage(TransferMessage transferMessage) {
    if (!transferMessage.getClient().getId().equals(userService.getActiveUser().getUserName())) {
      broadcast(transferMessage);
    }
  }

  public void broadcast(TransferMessage transferMessage) {
    ResponseMessage responseObject = restTemplate
            .postForObject(ApplicationSettings.getChatAppPeerAddresss(), transferMessage, ResponseMessage.class);
  }

  @Override
  public String toString() {
    return "TransferMessageService{" +
            "transferMessage=" + transferMessage +
            ", userService=" + userService +
            ", client=" + client +
            ", restTemplate=" + restTemplate +
            '}';
  }
}
