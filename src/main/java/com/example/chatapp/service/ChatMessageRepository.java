package com.example.chatapp.service;


import com.example.chatapp.model.ChatMessage;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

  List<ChatMessage> findAll();

  List<ChatMessage> findTop20ByOrderByTimestampDesc();

//  List<ChatMessage> findAllByUsernameByOrderByTimestampDesc(String username);
}
