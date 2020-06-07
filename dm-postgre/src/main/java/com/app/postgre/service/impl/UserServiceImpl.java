package com.app.postgre.service.impl;

import com.app.postgre.entity.JUser;
import com.app.postgre.repository.UserRepository;
import com.app.postgre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractDataServiceImpl<JUser, UserRepository> implements UserService {

  @Autowired
  public UserServiceImpl(UserRepository repository) {
    super(repository);
  }

  @Override
  public JUser getUserByName(String name) {
    return repository.findByName(name);
  }

  public JUser getUserByEmail(String email) {
    return repository.findByEmail(email);
  }
}
