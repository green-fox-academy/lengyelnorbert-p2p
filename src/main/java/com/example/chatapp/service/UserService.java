package com.example.chatapp.service;


import com.example.chatapp.model.FrontEndMessages;
import com.example.chatapp.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

//  @Autowired
//  User user;

  @Autowired
  UserRepository userRepository;

  public String registerUser(String userName) {
    if (userName.equals("")) {
      FrontEndMessages.setFrontEndMessageToShow(FrontEndMessages.getUserNameFieldIsEmpty());
      return "redirect:/register";
    }
    Iterable<User> users = userRepository.findAll();
    for (User user : users) {
      if (user.getUserName().equals(userName)) {
        return "redirect:/";
      }
    }
    userRepository.save(new User(userName));
    return "redirect:/";
  }
}
