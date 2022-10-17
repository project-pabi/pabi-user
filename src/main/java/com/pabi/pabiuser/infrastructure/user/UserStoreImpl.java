package com.pabi.pabiuser.infrastructure.user;

import com.pabi.pabiuser.domain.user.User;
import com.pabi.pabiuser.domain.user.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

  private final UserRepository userRepository;

  @Override
  public User inputUser(User user) {
    return userRepository.save(user);
  }
}
