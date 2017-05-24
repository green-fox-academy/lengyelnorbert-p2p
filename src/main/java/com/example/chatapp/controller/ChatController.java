package com.example.chatapp.controller;


import com.example.chatapp.model.FrontEndMessages;
import com.example.chatapp.service.ChatMessageService;
import com.example.chatapp.service.LogMessageService;
import com.example.chatapp.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

  @Autowired
  LogMessageService logMessageService;

  @Autowired
  UserService userService;

  @Autowired
  ChatMessageService chatMessageService;

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public String handleMissingInput(MissingServletRequestParameterException e) {
    return "Error: " + e.getParameterName();
  }

  @ExceptionHandler(Exception.class)
  public String handleError(Exception e) {
    return "Error: " + e.getMessage();
  }

  @ModelAttribute
  private void loginfo(HttpServletRequest httpServletRequest) {
    logMessageService.getinfo(httpServletRequest);
  }

  @RequestMapping(value = {"/"}, method = RequestMethod.GET)
  public String index(Model model) {
    if (userService.getUserTableSize() == 0) {
      return "redirect:/register";
    }
    model.addAttribute("frontendinfomessage", FrontEndMessages.getFrontEndMessageToShow());
    model.addAttribute("activeuser", userService.getActiveUser().getUserName());
    model.addAttribute("messagelist", chatMessageService.getAllChatMessage());
    model.addAttribute("latesttwentydesc", chatMessageService.getLatestTwentyMessageDesc());
    model.addAttribute("uniqueuserlist", chatMessageService.getUniqueUserList());
    model.addAttribute("messagesbyuniqueuser", chatMessageService.getMessagesByUniqueUser());
    return "index";
  }

  @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
  public String register(Model model) {
    model.addAttribute("frontendinfomessage", FrontEndMessages.getFrontEndMessageToShow());
    return "register";
  }

  @RequestMapping(value = "/userregister", method = RequestMethod.GET)
  public String userRegister(@RequestParam(value = "username") String userName) {
    return userService.registerUser(userName);
  }

  @RequestMapping(value = "/userupdate", method = RequestMethod.GET)
  public String userUpdate(@RequestParam(value = "usernameupdate") String userName) {
    return userService.updateUser(userName);
  }
}
