package com.pabi.pabiuser.interfaces.user;

import com.pabi.pabiuser.domain.Address.Address;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @ApiModel(value = "User 기본 Request")
  public static class UserRequest{
    @ApiModelProperty(value = "이메일 아이디", example = "test@gmail.com", required = true)
    private String email;
    @ApiModelProperty(value = "비밀번호", example = "test12!@", required = true)
    private String password;
    @ApiModelProperty(value = "닉네임", example = "닉네임", required = true)
    private String nickName;
    private Address address;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @ApiModel(value = "User 수정 Request")
  public static class UserModifyRequest {
    @ApiModelProperty(value = "이메일 아이디", required = true, example = "test@gmail.com")
    private String email;
    @ApiModelProperty(value = "닉네임", required = true, example = "닉네임수정")
    private String nickName;
    @ApiModelProperty(value = "주소")
    private Address address;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  @ApiModel(value = "User 기본 Response")
  public static class UserResponse{

    @ApiModelProperty(value = "PK ID", required = true)
    private Long id;
    @ApiModelProperty(value = "이메일 아이디", required = true)
    private String email;
    @ApiModelProperty(value = "닉네임", required = true)
    private String nickName;
    @ApiModelProperty(value = "주소")
    private Address address;
  }
}
