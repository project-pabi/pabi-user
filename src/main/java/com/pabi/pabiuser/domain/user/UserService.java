package com.pabi.pabiuser.domain.user;

public interface UserService {

  UserInfo.getUserOneInfo getUserOne(UserCommand.UserRequest command);

}
