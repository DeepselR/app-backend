package com.app.postgre.service;

import com.app.postgre.entity.JUser;

public interface UserDataService extends DataService<JUser> {

  JUser getUserByName(String name);

  JUser getUserByEmail(String email);

}
