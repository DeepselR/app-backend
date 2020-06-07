package com.app.postgre.entity;

import com.app.postgre.standart.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
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

}
