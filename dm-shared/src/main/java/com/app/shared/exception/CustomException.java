package com.app.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class CustomException extends RuntimeException {

  @Getter
  @Setter
  private HttpStatus status;

  @Getter
  @Setter
  private String message;

}
