package com.pabi.pabiuser.common.exception.user;

import com.pabi.pabiuser.common.exception.BaseException;
import com.pabi.pabiuser.common.response.ErrorCode;

public class DuplicateUserNickNameException extends BaseException {
  public DuplicateUserNickNameException() {
    super(ErrorCode.DUPLICATE_USER_NICKNAME);
  }

  public DuplicateUserNickNameException(String message) {
    super(message, ErrorCode.DUPLICATE_USER_NICKNAME);
  }
}
