package com.app.auth.model;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RegisterRequest {

  @NotNull
  private String name;

  @NotNull
  private String password;

  @NotNull
  private String email;



}
