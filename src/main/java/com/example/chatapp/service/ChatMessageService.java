package com.example.chatapp.service;


import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.model.TransferMessage;
import com.example.chatapp.model.UniqueUser;
import com.example.chatapp.model.User;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageService {

  List<UniqueUser> uniqueUserList;
  List<ChatMessage> messagesByUniqueUser;
  UniqueUser uniqueUser;

  @Autowired
  ChatMessageRepository chatMessageRepository;

  @Autowired
  UserService userService;

  @Autowired
  TransferMessageService transferMessageService;

  public UniqueUser getUniqueUser() {
    return uniqueUser;
  }

  public void setUniqueUser(UniqueUser uniqueUser) {
    this.uniqueUser = uniqueUser;
  }

  public void addNewChatMessage(String message) {
    ChatMessage chatMessage = new ChatMessage();
    chatMessage.setusername(userService.getActiveUser().getUserName());
    chatMessage.setText(message);
    while (checkChatMessageID(chatMessage.getId())) {
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
    List<ChatMessage> newList = reformatTimestampToDisplay(chatMessageRepository.findAll());
    return newList;
  }

  public List<UniqueUser> getUniqueUserList() {
    uniqueUserList = new ArrayList<>();
    for (ChatMessage chatmessage : chatMessageRepository.findAll()) {
      String tempName = chatmessage.getusername();
      if (!doesUniqueUserListContain(tempName)) {
        uniqueUserList.add(new UniqueUser(tempName));
      }
    }
    Collections.sort(uniqueUserList);
    return uniqueUserList;
  }

  private boolean doesUniqueUserListContain(String tempName) {
    for (UniqueUser uniqueuser : uniqueUserList) {
      if (uniqueuser.getUniqueUserName().equals(tempName)) {
        return true;
      }
    }
    return false;
  }

  public List<ChatMessage> getLatestTwentyMessageDesc() {
    return chatMessageRepository.findTop20ByOrderByTimestampDesc();
  }

  public List<ChatMessage> reformatTimestampToDisplay(List<ChatMessage> listToFormat) {
    List<ChatMessage> formattedList = new ArrayList<>();
    for (ChatMessage message : listToFormat) {
      formattedList.add(reformatTimeStamp(message));
    }
    return formattedList;
  }

  public ChatMessage reformatTimeStamp(ChatMessage message) {
    try {
      Timestamp timestamp = new Timestamp(Long.parseLong(message.getTimestamp()));
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      String dateAndTime = dateFormat.format(timestamp);
      message.setTimestamp(dateAndTime);
      return message;
    } catch (Exception e) {
      System.out.println("error> " + e);
    }
    return message;
  }

  public List<ChatMessage> getMessagesByUniqueUser() {
    messagesByUniqueUser = new ArrayList<>();
    if (!(uniqueUser == null)) {
      for (ChatMessage chatmessage : chatMessageRepository.findAll()) {
        if (uniqueUser.getUniqueUserName().toLowerCase()
                .equals(chatmessage.getusername().toLowerCase())) {
          messagesByUniqueUser.add(chatmessage);
        }
      }
    }
    return messagesByUniqueUser;
  }
}
