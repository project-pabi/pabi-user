package com.pabi.pabiuser.domain.user;

public interface UserReader {
  User findUserInfo(Long userId);

  boolean nickNameDuplicateCheck(String nickName);

  boolean emailDuplicateCheck(String email);
}
