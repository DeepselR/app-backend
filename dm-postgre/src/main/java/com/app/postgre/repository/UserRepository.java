package com.app.postgre.repository;

import com.app.postgre.model.JUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<JUser, Long> {

  JUser findByName(String name);

  JUser findByEmail(String email);

}