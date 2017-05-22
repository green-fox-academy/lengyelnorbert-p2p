package com.example.chatapp.service;


import com.example.chatapp.model.ResponseOK;
import com.example.chatapp.model.ResponseObject;
import org.springframework.stereotype.Component;

@Component
public class ResponseService {

  public ResponseOK statusOK(){
    return new ResponseOK();
  }
}
