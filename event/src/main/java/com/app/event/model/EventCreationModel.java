package com.app.event.model;

import com.app.postgre.EventType;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EventCreationModel {

  private String title;

  private String description;

  private EventType type;

  private LocalDateTime date;

}
