package com.app.postgre.entity;

import com.app.postgre.EventType;
import com.app.postgre.generator.KeyGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
@JsonInclude(Include.NON_NULL)
public class Event extends AbstractEntity {

  @Column(unique = true)
  private String key;

  @Column
  private String title;

  @Column
  private String description;

  @Column
  private EventType type;

  @Column
  private LocalDateTime date;

  @Column
  private LocalDate createDate;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  @JsonBackReference
  private JUser organizer;

  @ManyToMany(mappedBy = "events")
  private Set<JUser> members;

  @PrePersist
  protected void onCreate() {
    setKey(KeyGenerator.getKey());
  }

}
