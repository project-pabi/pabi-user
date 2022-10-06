package com.pabi.pabiuser.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserCommand {
  @Getter
  @Builder
  @AllArgsConstructor
  public static class UserRequest{
    private String userIdCommand;
  }
}
