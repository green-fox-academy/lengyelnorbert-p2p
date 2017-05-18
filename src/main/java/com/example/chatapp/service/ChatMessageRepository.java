package com.example.chatapp.service;


import com.example.chatapp.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {

}
