package com.example.chatapp.service;


import com.example.chatapp.model.LogMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogMessageService {

  @Autowired
  LogMessage logMessage;


  private void setLogMessageDateAndTime() {
    logMessage.setDateAndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
  }

  private void setLogMessageMethod(HttpServletRequest httpServletRequest) {
    logMessage.setMehtod(httpServletRequest.getMethod());
  }

  private void setLogMessagePath(HttpServletRequest httpServletRequest) {
    logMessage.setPath(httpServletRequest.getRequestURI());
  }

  private void setLogMessageRequestData(HttpServletRequest httpServletRequest) {
    logMessage.setRequestData(httpServletRequest.getQueryString());
  }

  private void setLogMessageLevel(String levelInfo) {
    logMessage.setLogLevel(levelInfo);
  }

  private void createLogMessage(HttpServletRequest httpServletRequest) {
    setLogMessagePath(httpServletRequest);
    setLogMessageMethod(httpServletRequest);
    setLogMessageDateAndTime();
    setLogMessageLevel("INFO");
    setLogMessageRequestData(httpServletRequest);
  }

  public void getinfo(HttpServletRequest httpServletRequest) {
    createLogMessage(httpServletRequest);
    String infoString =
            logMessage.getDateAndTime() + " " + logMessage.getLogLevel() + " Request "
                    + logMessage
                    .getPath() + " " + logMessage.getMehtod() + " " + logMessage
                    .getRequestData();
    System.out.println(infoString);
    printLogMessage();
  }

  // REDO TODO this one - still not working
  private void printLogMessage() {
    if (System.getenv("CHAT_APP_LOGLEVEL") != null) {
      if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")) {
        String infoString =
                logMessage.getDateAndTime() + " " + logMessage.getLogLevel() + " Request "
                        + logMessage
                        .getPath() + " " + logMessage.getMehtod() + " " + logMessage
                        .getRequestData();
        System.out.println(infoString);
      } else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")) {
        System.out.println("No logmessage provided - CHAT_APP_LOGLEVEL set to ERROR");
      }
    }
  }
}
