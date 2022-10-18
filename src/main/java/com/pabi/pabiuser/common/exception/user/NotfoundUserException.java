package com.pabi.pabiuser.common.exception.user;

import com.pabi.pabiuser.common.exception.BaseException;
import com.pabi.pabiuser.common.response.ErrorCode;

public class NotfoundUserException extends BaseException {
  public NotfoundUserException() {
    super(ErrorCode.USER_NOT_FOUND);
  }

  public NotfoundUserException(String message) {
    super(message, ErrorCode.USER_NOT_FOUND);
  }
}
