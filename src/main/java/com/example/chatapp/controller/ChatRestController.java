package com.example.chatapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRestController {

  @RequestMapping(value = "/userregister", method = RequestMethod.GET)
  public String userRegister(@RequestParam(value = "username") String userName) {
    System.out.println(userName);
    return "redirect:/";
  }
}
