package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.common.exception.user.DuplicateUserEmailException;
import com.pabi.pabiuser.common.exception.user.DuplicateUserNickNameException;
import com.pabi.pabiuser.domain.user.UserInfo.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {

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
    if(userReader.emailDuplicateCheck(commend.getEmail())) {
      throw new DuplicateUserEmailException();
    }
    if(userReader.nickNameDuplicateCheck(commend.getNickName())) {
      throw new DuplicateUserNickNameException();
    }
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

  @Override
  public boolean nickNameDuplicateCheck(String nickName) {
    return userReader.nickNameDuplicateCheck(nickName);
  }

  @Override
  public boolean emailDuplicateCheck(String email) {
    return userReader.emailDuplicateCheck(email);
  }
}
