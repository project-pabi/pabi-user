package com.pabi.pabiuser.application.user;

import com.pabi.pabiuser.domain.user.UserCommand;
import com.pabi.pabiuser.domain.user.UserCommand.Request;
import com.pabi.pabiuser.domain.user.UserInfo;
import com.pabi.pabiuser.domain.user.UserService;
import com.pabi.pabiuser.interfaces.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserFacade {
  private final UserService userService;

  public UserInfo.Main findUserInfo(Long userId) {
    return userService.findUserInfo(userId);
  }

  public Long inputUser(UserCommand.Request commend) {
    return userService.inputUser(commend);
  }

  public void modifyUser(UserCommand.ModifyRequest command) {
    userService.modifyUser(command);
  }

  public void deleteUser(Long userId) {
    userService.deleteUser(userId);
  }

  public boolean nickNameDuplicateCheck(String nickName) {
    return userService.nickNameDuplicateCheck(nickName);
  }

  public boolean emailDuplicateCheck(String email) {
    return userService.emailDuplicateCheck(email);
  }
}
