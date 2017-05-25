package com.example.chatapp.service;


import com.example.chatapp.model.ResponseMessage;
import org.springframework.stereotype.Component;

@Component
public class ResponseService {

  public ResponseMessage statusOK(){
    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setStatus("ok");
    return responseMessage;
  }

  public ResponseMessage statusError(String errorMessage){
    ResponseMessage responseMessage = new ResponseMessage();
    responseMessage.setStatus("error");
    responseMessage.setMessage(errorMessage);
    return responseMessage;
  }
}
