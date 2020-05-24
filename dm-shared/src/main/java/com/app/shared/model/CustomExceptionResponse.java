package com.app.shared.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CustomExceptionResponse {

  private LocalDate timestamp;

  private int status;

  private String error;

  private String message;

  private String path;

}
