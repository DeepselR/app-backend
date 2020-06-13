package com.app.shared.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Shared end-points constants.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestPoints {

  /**
   * Authentication end-point.
   */
  public static final String AUTHENTICATE = "/authenticate";

  /**
   * Registration end-point.
   */
  public static final String REGISTER = "/register";

}
