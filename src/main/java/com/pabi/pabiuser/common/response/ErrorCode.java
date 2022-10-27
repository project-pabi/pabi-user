package com.pabi.pabiuser.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
  COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
  COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
  COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다."),
  COMMON_ILLEGAL_STATUS("잘못된 상태값입니다."),

  // GIFT
  GIFT_NOT_RECEIVABLE_CONDITION("선물 수락이 가능한 상태가 아닙니다."),
  GIFT_NOT_MODIFY_DELIVERY_CONDITION("배송지 변경이 가능한 상태가 아닙니다."),

  // User
  DUPLICATE_USER_EMAIL("이미 가입 되어 있는 유저 이메일 입니다."),
  DUPLICATE_USER_NICKNAME("이미 가입 되어 있는 유저 닉네임 입니다."),
  FORBIDDEN_ERROR("접근할 수 없습니다."),
  LOGIN_ID_ERROR("존재하지 않는 아이디입니다."),
  USER_NOT_FOUND("존재하지 않는 유저입니다."),
  LOGIN_PASSWORD_ERROR("비밀번호가 틀렸습니다."),

  // Category
  DUPLICATE_CATEGORY("중복 카테고리가 있습니다.");

  private final String errorMsg;

  public String getErrorMsg(Object... arg) {
    return String.format(errorMsg, arg);
  }
}
