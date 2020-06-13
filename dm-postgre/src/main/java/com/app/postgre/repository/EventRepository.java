package com.app.postgre.repository;

import com.app.postgre.entity.Event;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CommonRepository<Event> {

  Optional<Event> findByKey(String key);

}
