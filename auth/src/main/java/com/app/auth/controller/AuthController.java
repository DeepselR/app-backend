package com.app.auth.controller;

import com.app.auth.model.AuthRequest;
import com.app.auth.model.AuthResponse;
import com.app.auth.model.RegisterRequest;
import com.app.postgre.model.JUser;
import com.app.postgre.service.UserService;
import com.app.postgre.standart.Role;
import com.app.security.util.JsonWebTokenService;
import com.app.shared.constants.RestPoints;
import com.app.shared.exception.CustomException;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private UserService userService;

  @Autowired
  private JsonWebTokenService jsonWebTokenService;

  @Autowired
  private PasswordEncoder encoder;

  @PostMapping(value = RestPoints.AUTHENTICATE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest)
      throws AuthenticationException {
    try {
      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    } catch (AuthenticationException exception) {
      throw new UsernameNotFoundException("Incorrect email or password", exception);
    }
    UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
    String token = jsonWebTokenService.generateToken(userDetails);
    return ResponseEntity.ok(new AuthResponse(token));
  }

  @PostMapping(value = RestPoints.REGISTER, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Integer> register(@RequestBody @Valid RegisterRequest request) throws AuthenticationException {
    JUser existUser = userService.getUserByEmail(request.getEmail());
    if (Objects.nonNull(existUser)) {
      throw new CustomException(HttpStatus.CONFLICT, "User with that email already exists");
    }
    JUser user = new JUser();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(encoder.encode(request.getPassword()));
    user.setRole(Role.USER);
    JUser saved = userService.save(user);
    return ResponseEntity.ok(saved.getId());
  }

}
