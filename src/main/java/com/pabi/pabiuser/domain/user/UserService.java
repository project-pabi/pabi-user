package com.pabi.pabiuser.domain.user;


import com.pabi.pabiuser.domain.user.UserCommand.Request;
import com.pabi.pabiuser.interfaces.user.UserDto;
import com.pabi.pabiuser.interfaces.user.UserDto.UserModifyRequest;

public interface UserService {

  UserInfo.Main findUserInfo(Long userId);

  Long inputUser(UserCommand.Request commend);

  void modifyUser(UserCommand.ModifyRequest command);

  void deleteUser(Long userId);
}
