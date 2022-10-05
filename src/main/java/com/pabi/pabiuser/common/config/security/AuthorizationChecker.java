package com.pabi.pabiuser.common.config.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationChecker {

  public boolean check(HttpServletRequest request, Authentication authentication) {
//        Object principalObj = authentication.getPrincipal();
//
//        if (!(principalObj instanceof Admin)) {
//            return false;
//        }
//        Admin admin = (Admin) principalObj;
//
//        for (String role : admin.getRoles()) {
//            if (new AntPathMatcher().match(role, request.getRequestURI())) {
//                return true;
//            }
//        }
//
    return false;
  }
}
