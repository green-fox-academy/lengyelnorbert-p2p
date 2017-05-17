package com.example.chatapp.controller;


import com.example.chatapp.model.LogMessage;
import com.example.chatapp.service.LogMessageService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

  @Autowired
  LogMessageService logMessageService;

  @ModelAttribute
  private void loginfo(HttpServletRequest httpServletRequest){
    logMessageService.getinfo(httpServletRequest);
  }

  @RequestMapping(value = {"/"}, method = RequestMethod.GET)
  public String index(Model model) {
        return "index";
  }
}
