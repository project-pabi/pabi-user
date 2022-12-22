package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.domain.user.address.Address;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserCommand {

  @Getter
  @Builder
  @AllArgsConstructor
  public static class Request {

    @Email(message = "이메일 형식이 아닙니다.")
    @NotBlank(message = "아이디를 입력해 주세요.")
    private String email;

    @Size(min = 8, max = 20, message = "8~20자 이내로 입력해 주세요.")
    @NotBlank(message = "비밀번호를 입력해 주세요.")
    private String nickName;

    @NotBlank(message = "닉네임을 입력해 주세요.")
    private String password;

    @Valid
    private Address address;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  public static class ModifyRequest {

    private Long id;

    @Email(message = "이메일 형식이 아닙니다.")
    private String email;
    private String nickName;

    @Valid
    private Address address;
  }
}
