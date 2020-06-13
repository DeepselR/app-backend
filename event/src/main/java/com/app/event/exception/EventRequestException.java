package com.app.event.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EventRequestException extends IllegalArgumentException {

  private HttpStatus status;

  private String message;

  public EventRequestException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }
}
