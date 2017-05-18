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

//  @Autowired
//  UserService userService;
//
//  @RequestMapping(value = "/userregister", method = RequestMethod.GET)
//  public void userRegister(HttpServletResponse httpServletResponse,
//          @RequestParam(value = "username") String userName) throws Exception {
//    String returnString = userService.registerUser(userName);
//    httpServletResponse.sendRedirect(returnString);
//  }
//
//  @RequestMapping(value = "/userupdate", method = RequestMethod.GET)
//  public void userUpdate(HttpServletResponse httpServletResponse,
//          @RequestParam(value = "usernameupdate") String userName) throws Exception {
//    String returnString = userService.updateUser(userName);
//    httpServletResponse.sendRedirect(returnString);
//  }
}
