package com.app.postgre.entity;

import com.app.postgre.EventType;
import com.app.postgre.generator.KeyGenerator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Event extends AbstractEntity {

  @Column(unique = true)
  @GeneratedValue(generator = KeyGenerator.generatorName)
  @GenericGenerator(name = KeyGenerator.generatorName, strategy = "com.app.postgre.generator.KeyGenerator")
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
  private JUser organizer;

  @ManyToMany(mappedBy = "events")
  private Set<JUser> members;

}
