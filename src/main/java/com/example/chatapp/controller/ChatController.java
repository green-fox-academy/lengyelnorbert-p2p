package com.example.chatapp.controller;


import com.example.chatapp.model.FrontEndMessages;
import com.example.chatapp.model.LogMessage;
import com.example.chatapp.model.User;
import com.example.chatapp.service.LogMessageService;
import com.example.chatapp.service.UserRepository;
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
    return "index";
  }

  @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
  public String register(Model model){
    model.addAttribute("errormessage", FrontEndMessages.getFrontEndMessageToShow());
    return "register";
  }

  @RequestMapping(value = "/userregister", method = RequestMethod.GET)
  public String userRegister(@RequestParam(value = "username") String userName) {
    userService.registerUser(userName);
//    userRepository.save(new User(userName));
    System.out.println(userName);
    return "redirect:/";
  }
}
