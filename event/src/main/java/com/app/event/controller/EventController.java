package com.app.event.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

  @RequestMapping(value = "/create")
  public String create() {
    return "Spring in Action";
  }

}
