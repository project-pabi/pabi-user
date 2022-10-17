package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.domain.user.UserInfo.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

  private final UserReader userReader;
  private final UserStore userStore;
  private final UserFactory userFactory;
  private final UserMapper userMapper;

  @Override
  public Main findUserInfo(Long userId) {
    return userMapper.of(userReader.findUserInfo(userId));
  }

  @Override
  @Transactional
  public Long inputUser(UserCommand.Request commend) {
    return userStore.inputUser(User.createUser(commend)).getId();
  }

  @Override
  @Transactional
  public void modifyUser(UserCommand.ModifyRequest command) {
    User user = userReader.findUserInfo(command.getId());
    user.modifyUser(command);
  }

  @Override
  @Transactional
  public void deleteUser(Long userId) {
    User user = userReader.findUserInfo(userId);
    userFactory.softDeleteUser(user);
  }
}
