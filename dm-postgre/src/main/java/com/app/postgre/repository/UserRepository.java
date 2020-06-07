package com.app.postgre.repository;

import com.app.postgre.entity.JUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CommonRepository<JUser> {

  JUser findByName(String name);

  JUser findByEmail(String email);

}