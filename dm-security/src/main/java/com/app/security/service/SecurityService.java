package com.app.security.service;

import com.app.postgre.entity.JUser;

public interface SecurityService {

  JUser getCurrentUser();

}
