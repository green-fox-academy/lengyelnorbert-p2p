package com.example.chatapp.service;


import com.example.chatapp.model.FrontEndMessages;
import com.example.chatapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  @Autowired
  UserRepository userRepository;

  private User activeUser;

  public User getActiveUser() {
    if (activeUser == null) {
      return userRepository.findOne(1l);
    } else {
      return activeUser;
    }
  }

  public void setActiveUser(User activeUser) {
    this.activeUser = activeUser;
  }

  public String registerUser(String userName) {
    if (userName.equals("")) {
      FrontEndMessages.setFrontEndMessageToShow("The username field is empty");
      return "redirect:/register";
    }
    Iterable<User> users = userRepository.findAll();
    for (User user : users) {
      if (user.getUserName().equals(userName)) {
        FrontEndMessages.setFrontEndMessageToShow("Username " + userName + " exists already");
        return "redirect:/register";
      }
    }
    User userToRegister = new User(userName);
    userRepository.save(userToRegister);
    activeUser = userToRegister;
    FrontEndMessages.setFrontEndMessageToShow("New user called " + userName + " saved");
    return "redirect:/";
  }

  public String updateUser(String userName) {
    if (userName.equals("")) {
      FrontEndMessages.setFrontEndMessageToShow("The username field is empty");
      return "redirect:/";
    }
    Iterable<User> users = userRepository.findAll();
    for (User user : users) {
      if (user.getUserName().equals(userName)) {
        activeUser = user;
        FrontEndMessages.setFrontEndMessageToShow("Welcome " + userName + "!");
        return "redirect:/";
      }
    }
    if (activeUser != null) {
      activeUser.setUserName(userName);
      userRepository.save(activeUser);
      FrontEndMessages
              .setFrontEndMessageToShow("You have changed your username to " + userName + "!");
      return "redirect:/";
    }
    FrontEndMessages.setFrontEndMessageToShow("No active user, nothing to update, please register");
    return "redirect:/register";
  }

  public int getUserTableSize(){
    return userRepository.findAll().size();
  }
}
