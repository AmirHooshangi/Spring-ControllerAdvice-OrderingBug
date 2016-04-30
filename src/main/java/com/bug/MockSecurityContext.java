package com.bug;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;

/**
 * Created by amir amirhoshangi@gmail.com
 */
@Component
public class MockSecurityContext implements SecurityContext {

  private static final long serialVersionUID = -1386535243513362694L;

  private Authentication authentication;

  public MockSecurityContext() {

  }

  public MockSecurityContext(Authentication authentication) {
    this.authentication = authentication;
  }


  public Authentication getAuthentication() {
    return this.authentication;
  }

  public void setAuthentication(Authentication authentication) {
    this.authentication = authentication;

  }
}
