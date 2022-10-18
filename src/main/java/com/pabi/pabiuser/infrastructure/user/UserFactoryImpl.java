package com.pabi.pabiuser.infrastructure.user;

import com.pabi.pabiuser.domain.user.User;
import com.pabi.pabiuser.domain.user.UserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserFactoryImpl implements UserFactory {

  @Override
  public void softDeleteUser(User user) {
    user.withdrawal();
  }
}
