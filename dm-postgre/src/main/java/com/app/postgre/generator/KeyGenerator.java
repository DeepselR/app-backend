package com.app.postgre.generator;

import java.time.LocalDateTime;
import java.util.UUID;

public class KeyGenerator {

  public static String getKey() {
    String identifier = UUID.randomUUID().toString().replace("-", "");
    String time = LocalDateTime.now().toString().replaceAll("\\W", "");
    return String.join("", identifier, time).toLowerCase();
  }

}
