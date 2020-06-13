package com.app.security.service.impl;

import com.app.postgre.entity.JUser;
import com.app.postgre.service.UserDataService;
import com.app.security.model.JUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDataService userDataService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    JUser jUser = userDataService.getUserByEmail(username);
    return new JUserDetails(jUser);
  }
}
