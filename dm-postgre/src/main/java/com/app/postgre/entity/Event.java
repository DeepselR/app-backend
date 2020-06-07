package com.app.postgre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Event extends AbstractEntity {

  @Column
  private String title;

}
