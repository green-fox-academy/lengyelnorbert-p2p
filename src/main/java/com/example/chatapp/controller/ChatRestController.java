package com.example.chatapp.controller;

import com.example.chatapp.model.ChatMessage;
import com.example.chatapp.model.Client;
import com.example.chatapp.model.ResponseObject;
import com.example.chatapp.model.TransferMessage;
import com.example.chatapp.service.ChatMessageService;
import com.example.chatapp.service.ResponseService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestController {

  @Autowired
  ChatMessageService chatMessageService;

  @Autowired
  ResponseService responseService;

  @RequestMapping(value = "/sendmessage", method = RequestMethod.POST)
  public void addMessage(HttpServletResponse httpServletResponse, String messageinput)
          throws Exception {
    chatMessageService.addNewChatMessage(messageinput);
    httpServletResponse.sendRedirect("/");
  }

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive", method = RequestMethod.POST)
  public ResponseObject receiveMessage(@RequestBody TransferMessage transferMessage) {
    chatMessageService.addNewReceivedMessage(transferMessage);
    return responseService.statusOK();
  }
}
