package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.domain.user.address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserInfo {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class Main {
 
    private Long id;
    private String email;
    private String nickName;
    private Address address;
  }

}
