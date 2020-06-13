package com.app.postgre.service;

import com.app.postgre.entity.Event;
import java.util.Optional;

public interface EventDataService extends DataService<Event> {

  Optional<Event> findByKey(String key);

}
