package com.pabi.pabiuser.infrastructure.user;

import com.pabi.pabiuser.common.exception.user.NotfoundUserException;
import com.pabi.pabiuser.domain.user.User;
import com.pabi.pabiuser.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

  private final UserRepository userRepository;

  public User findUserInfo(Long userId) {
    return userRepository.findByIdAndWithdrawalFalse(userId).orElseThrow(NotfoundUserException::new);
  }
}
