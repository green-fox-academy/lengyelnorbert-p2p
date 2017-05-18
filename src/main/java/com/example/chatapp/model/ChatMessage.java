package com.example.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "chattable")
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idOnTable;
  private String userName;
  private String text;
  private int generatedID;

  public ChatMessage() {
  }
}