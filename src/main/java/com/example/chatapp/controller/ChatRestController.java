package com.example.chatapp.controller;


import com.example.chatapp.model.ResponseMessage;
import com.example.chatapp.model.TransferMessage;
import com.example.chatapp.model.UniqueUser;
import com.example.chatapp.service.ChatMessageService;
import com.example.chatapp.service.ResponseService;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
  public ResponseMessage receiveMessage(@RequestBody TransferMessage transferMessage) {
    String errorString = chatMessageService.checkReceivedMessageIfValid(transferMessage);
    if (!errorString.equals("Missing field(s):")) {
      return responseService.statusError(errorString);
    }
    chatMessageService.addNewReceivedMessage(transferMessage);
    return responseService.statusOK();
  }

  @RequestMapping(value = "/listuniqueusermessage", method = RequestMethod.POST)
  public void uniqueUserMessage(HttpServletResponse httpServletResponse, UniqueUser uniqueuser)
          throws Exception {
    System.out.println(uniqueuser.getUniqueUserName());
    chatMessageService.setUniqueUserName(uniqueuser.getUniqueUserName());
    httpServletResponse.sendRedirect("/");
  }
}
