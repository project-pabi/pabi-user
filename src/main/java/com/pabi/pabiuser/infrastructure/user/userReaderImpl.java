package com.pabi.pabiuser.infrastructure.user;

import com.pabi.pabiuser.domain.user.User;
import com.pabi.pabiuser.domain.user.UserCommand;
import com.pabi.pabiuser.domain.user.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class userReaderImpl implements UserReader {

  private final UserRepository userRepository;

  @Override
  public User getUserOne(UserCommand.UserRequest command) {
    return userRepository.findByEmail(command.getUserIdCommand());
  }
}
