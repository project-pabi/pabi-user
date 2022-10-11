package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.domain.user.UserInfo.getUserOneInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

  private final UserReader userReader;

  private final UserMapper userMapper;

  @Override
  public UserInfo.getUserOneInfo getUserOne(UserCommand.UserRequest command) {
    return userMapper.of(userReader.getUserOne(command));
  }
}
