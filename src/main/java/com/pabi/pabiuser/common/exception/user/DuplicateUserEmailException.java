package com.pabi.pabiuser.common.exception.user;

import com.pabi.pabiuser.common.exception.BaseException;
import com.pabi.pabiuser.common.response.ErrorCode;

public class DuplicateUserEmailException extends BaseException {
  public DuplicateUserEmailException() {
    super(ErrorCode.DUPLICATE_USER_EMAIL);
  }

  public DuplicateUserEmailException(String message) {
    super(message, ErrorCode.DUPLICATE_USER_EMAIL);
  }
}
