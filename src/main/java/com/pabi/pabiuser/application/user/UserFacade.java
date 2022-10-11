package com.pabi.pabiuser.application.user;

import com.pabi.pabiuser.domain.user.UserCommand;
import com.pabi.pabiuser.domain.user.UserInfo;
import com.pabi.pabiuser.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {
  private final UserService userService;

  public UserInfo.getUserOneInfo getUserOne(UserCommand.UserRequest command) {
    return userService.getUserOne(command);
  }

}
