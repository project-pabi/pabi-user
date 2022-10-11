package com.pabi.pabiuser.domain.user;

public interface UserReader {
  User getUserOne(UserCommand.UserRequest command);

}
