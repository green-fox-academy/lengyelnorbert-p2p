package com.example.chatapp.model;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "chattable")
public class ChatMessage {

  @Id
  private int id = calculateRandomID();
  private String userName;
  private String text;
  private String timestamp = String.valueOf(System.currentTimeMillis());

  public ChatMessage() {
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getText() {
    return text;
  }

  public String getTimestamp() {
    return timestamp;
  }

  private int calculateRandomID(){
    Random r = new Random();
    return r.nextInt(9999999-1000000) + 1000000;
  }
}