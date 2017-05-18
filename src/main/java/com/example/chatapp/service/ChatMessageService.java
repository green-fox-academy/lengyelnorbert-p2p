package com.example.chatapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatMessageService {

  @Autowired
  ChatMessageRepository chatMessageRepository;


}
