package com.app.security.model;

import com.app.postgre.model.JUser;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JUserDetails implements UserDetails {

  @Setter
  private JUser userData;

  private boolean accountNonExpired;

  private boolean accountNonLocked;

  private boolean credentialsNonExpired;

  private List<GrantedAuthority> authorities;

  private boolean enabled;


  public JUserDetails(JUser userData) {
    this.userData = userData;
    this.accountNonExpired = true;
    this.accountNonLocked = true;
    this.credentialsNonExpired = true;
    this.enabled = true;
    this.authorities = Collections.singletonList(new SimpleGrantedAuthority(userData.getRole().name()));
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return userData.getPassword();
  }

  @Override
  public String getUsername() {
    return userData.getName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
