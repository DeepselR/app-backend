package com.app.postgre.service;

import com.app.postgre.entity.JUser;

public interface UserService extends DataService<JUser> {

  JUser getUserByName(String name);

  JUser getUserByEmail(String email);

}
