package com.example.chatapp.model;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "chattable")
public class ChatMessage {

  @Id
  private int id = calculateRandomID();
  private String username;
  private String text;
  private String timestamp = String.valueOf(System.currentTimeMillis());

  public ChatMessage() {
  }

  public void setusername(String username) {
    this.username = username;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setId(int id) {
    this.id = id;
  }
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public int getId() {
    return id;
  }

  public String getusername() {
    return username;
  }

  public String getText() {
    return text;
  }

  public String getTimestamp() {
    return timestamp;
  }

  private int calculateRandomID() {
    Random r = new Random();
    return r.nextInt(9999999 - 1000000) + 1000000;
  }
}