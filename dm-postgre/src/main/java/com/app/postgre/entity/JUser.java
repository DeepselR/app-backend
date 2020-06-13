package com.app.postgre.entity;

import com.app.postgre.standart.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class JUser extends AbstractEntity {

  @Column
  private String name;

  @Column(unique = true)
  private String email;

  @Column
  private String password;

  @Column
  private Role role;

  @OneToMany(mappedBy = "organizer")
  private Set<Event> ownEvents;

  @ManyToMany
  @JoinTable(name = "member_events",
      joinColumns = {
          @JoinColumn(name = "member_id", referencedColumnName = "id")
      },
      inverseJoinColumns = {
          @JoinColumn(name = "event_id", referencedColumnName = "id")
      }
  )
  @JsonManagedReference
  private Set<Event> events;

}
