package com.example.chatapp.controller;

import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.service.ChatMessageService;
import com.example.chatapp.service.UserService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestController {

  @Autowired
  ChatMessageService chatMessageService;

  @RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
  public void addMessage(HttpServletResponse httpServletResponse, String messageinput) throws Exception {
    chatMessageService.addNewChatMessage(messageinput);
    httpServletResponse.sendRedirect("/");
  }
}
