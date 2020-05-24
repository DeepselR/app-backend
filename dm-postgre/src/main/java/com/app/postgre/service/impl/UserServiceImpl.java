package com.app.postgre.service.impl;

import com.app.postgre.model.JUser;
import com.app.postgre.repository.UserRepository;
import com.app.postgre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public JUser save(JUser JUser) {
    return userRepository.save(JUser);
  }

  @Override
  public JUser getUserByName(String name) {
    return userRepository.findByName(name);
  }

  public JUser getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }
}
