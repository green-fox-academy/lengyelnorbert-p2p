package com.example.chatapp.service;


import com.example.chatapp.model.ChatMessage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageService {

  @Autowired
  ChatMessageRepository chatMessageRepository;

  @Autowired
  UserService userService;

  public void addNewChatMessage(String message){
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setUserName(userService.getActiveUser().getUserName());
    chatMessage.setText(message);
    chatMessageRepository.save(chatMessage);
  }

  public List<ChatMessage> getAllChatMessage(){
    return chatMessageRepository.findAll();
  }
}
