package com.pabi.pabiuser.interfaces.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserDto {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class UserRequest{
    private String userId;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  public static class UserResponse{
    private String userId;
  }
}
