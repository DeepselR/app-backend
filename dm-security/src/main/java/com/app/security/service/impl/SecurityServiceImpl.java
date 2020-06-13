package com.app.security.service.impl;

import com.app.postgre.entity.JUser;
import com.app.security.model.JUserDetails;
import com.app.security.service.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

  @Override
  public JUser getCurrentUser() {
    return getUserDetails().getUserData();
  }


  private JUserDetails getUserDetails() {
    return (JUserDetails) getAuthentication().getPrincipal();
  }

  private Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
