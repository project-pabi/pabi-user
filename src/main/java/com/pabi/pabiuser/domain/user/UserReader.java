package com.pabi.pabiuser.domain.user;

public interface UserReader {
  PabiUser getUserOne(UserCommand.UserRequest command);

}
