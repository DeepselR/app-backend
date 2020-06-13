package com.app.event.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.app.event.exception.EventRequestException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class EventExceptionHandler {

  @ExceptionHandler
  public void handle(HttpServletResponse response, EventRequestException exception) throws IOException {
    response.sendError(BAD_REQUEST.value(), exception.getMessage());
  }

}
