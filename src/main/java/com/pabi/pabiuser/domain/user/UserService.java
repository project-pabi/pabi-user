package com.pabi.pabiuser.domain.user;


public interface UserService {

  UserInfo.Main findUserInfo(Long userId);

  Long inputUser(UserCommand.Request commend);

  void modifyUser(UserCommand.ModifyRequest command);

  void deleteUser(Long userId);

  boolean nickNameDuplicateCheck(String nickName);

  boolean emailDuplicateCheck(String email);
}
