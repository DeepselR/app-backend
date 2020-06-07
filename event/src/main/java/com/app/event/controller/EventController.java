package com.app.event.controller;

import com.app.postgre.entity.Event;
import com.app.postgre.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

  @Autowired
  private DataService<Event> dataService;

  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Event> create() {
    Event event = new Event();
    Event savedEvent = dataService.save(event);
    return ResponseEntity.ok(savedEvent);
  }

}
