package com.app.event.controller;

import com.app.event.constant.RestPoints;
import com.app.event.exception.EventRequestException;
import com.app.event.handler.EventExceptionHandler;
import com.app.event.model.EventCreationModel;
import com.app.postgre.entity.Event;
import com.app.postgre.service.EventDataService;
import com.app.security.service.SecurityService;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController extends EventExceptionHandler {

  private final EventDataService dataService;

  private final SecurityService securityService;

  public EventController(EventDataService dataService, SecurityService securityService) {
    this.dataService = dataService;
    this.securityService = securityService;
  }

  @PostMapping(value = RestPoints.CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Long> create(EventCreationModel model) {
    Event event = new Event();
    event.setTitle(model.getTitle());
    event.setDescription(model.getDescription());
    event.setDate(model.getDate());
    event.setType(model.getType());
    event.setCreateDate(LocalDate.now());
    event.setOrganizer(securityService.getCurrentUser());
    Event savedEvent = dataService.save(event);
    return ResponseEntity.ok(savedEvent.getId());
  }

  @GetMapping(value = RestPoints.GET + "/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Event> getEvent(@PathVariable String key) {
    Event event = dataService.findByKey(key)
        .orElse(null);
    if (Objects.nonNull(event)) {
      return ResponseEntity.ok(event);
    }
    throw new EventRequestException(HttpStatus.NOT_FOUND, "Event Not Found");
  }

  @DeleteMapping(value = RestPoints.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
  public void delete(Long id) {
    dataService.findById(id)
        .ifPresent(dataService::delete);
  }


}
