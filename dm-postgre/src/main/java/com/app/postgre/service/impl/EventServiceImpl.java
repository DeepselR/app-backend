package com.app.postgre.service.impl;

import com.app.postgre.entity.Event;
import com.app.postgre.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends AbstractDataServiceImpl<Event, EventRepository> {

  @Autowired
  public EventServiceImpl(EventRepository repository) {
    super(repository);
  }

}
