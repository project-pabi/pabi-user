package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.domain.Address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserCommand {
  @Getter
  @Builder
  @AllArgsConstructor
  public static class Request {
    private String email;
    private String nickName;
    private String password;
    private Address address;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  public static class ModifyRequest {

    private Long id;
    private String email;
    private String nickName;
    private Address address;
  }
}
