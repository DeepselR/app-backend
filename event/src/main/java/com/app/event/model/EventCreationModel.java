package com.app.event.model;

import com.app.postgre.EventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EventCreationModel {

  private String title;

  private String description;

  private EventType type;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime date;

}
