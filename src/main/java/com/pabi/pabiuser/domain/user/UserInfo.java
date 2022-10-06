package com.pabi.pabiuser.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserInfo {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class getUserOneInfo{
    private String email;
    private String password;
    private String nickName;
  }

}
