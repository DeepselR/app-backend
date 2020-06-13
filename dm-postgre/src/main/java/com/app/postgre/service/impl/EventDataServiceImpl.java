package com.app.postgre.service.impl;

import com.app.postgre.entity.Event;
import com.app.postgre.repository.EventRepository;
import com.app.postgre.service.EventDataService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventDataServiceImpl extends AbstractDataServiceImpl<Event, EventRepository> implements EventDataService {

  @Autowired
  public EventDataServiceImpl(EventRepository repository) {
    super(repository);
  }

  @Override
  public Optional<Event> findByKey(String key) {
    return repository.findByKey(key);
  }
}
