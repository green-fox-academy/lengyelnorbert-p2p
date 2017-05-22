package com.example.chatapp.service;


import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.model.TransferMessage;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageService {

  @Autowired
  ChatMessageRepository chatMessageRepository;

  @Autowired
  UserService userService;

  @Autowired
  TransferMessageService transferMessageService;

  public void addNewChatMessage(String message) {
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setusername(userService.getActiveUser().getUserName());
    chatMessage.setText(message);
    while (checkChatMessageID(chatMessage.getId())){
      chatMessage.setId(chatMessage.calculateRandomID());
    }
    chatMessageRepository.save(chatMessage);
    transferMessageService.transferOwnMessage(chatMessage);
  }

  public void addNewReceivedMessage(TransferMessage transferMessage) {
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setId(transferMessage.getMessage().getId());
    chatMessage.setusername(transferMessage.getMessage().getusername());
    chatMessage.setText(transferMessage.getMessage().getText());
    chatMessage.setTimestamp(transferMessage.getMessage().getTimestamp());
    chatMessageRepository.save(chatMessage);
    transferMessageService.transferOtherMessage(transferMessage);
  }

  public boolean checkChatMessageID(long messageIDToValidate) {
    return (chatMessageRepository.exists(messageIDToValidate));
  }

  public List<ChatMessage> getAllChatMessage() {
    return chatMessageRepository.findAll();
  }
}

