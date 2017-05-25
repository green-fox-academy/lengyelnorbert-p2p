package com.example.chatapp.model;

import com.example.chatapp.service.ChatMessageService;
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
  private long id = calculateRandomID();
  private String username;
  private String text;
  private String timestamp;

  public ChatMessage() {
  }

  public void setusername(String username) {
    this.username = username;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public void setTimestampForNow(){
    timestamp = String.valueOf(System.currentTimeMillis());
  }

  public long getId() {
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

  public long calculateRandomID() {
    Random r = new Random();
    int random = r.nextInt(9999999 - 1000000) + 1000000;
    return Long.valueOf(random);
  }

  @Override
  public String toString() {
    return "ChatMessage{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", text='" + text + '\'' +
            ", timestamp='" + timestamp + '\'' +
            '}';
  }
}