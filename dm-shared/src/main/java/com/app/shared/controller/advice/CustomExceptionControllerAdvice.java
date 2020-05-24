package com.app.shared.controller.advice;

import com.app.shared.exception.CustomException;
import com.app.shared.model.CustomExceptionResponse;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionControllerAdvice {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<CustomExceptionResponse> handleException(HttpServletRequest request, CustomException exception) {
    CustomExceptionResponse model = new CustomExceptionResponse();
    model.setTimestamp(LocalDate.now());
    model.setStatus(exception.getStatus().value());
    model.setError(exception.getStatus().getReasonPhrase());
    model.setMessage(exception.getMessage());
    model.setPath(request.getServletPath());
    return ResponseEntity.status(exception.getStatus()).body(model);
  }

}
