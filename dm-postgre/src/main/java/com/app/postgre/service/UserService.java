package com.app.postgre.service;

import com.app.postgre.model.JUser;

public interface UserService {

  JUser save(JUser JUser);

  JUser getUserByName(String name);

  JUser getUserByEmail(String email);

}
