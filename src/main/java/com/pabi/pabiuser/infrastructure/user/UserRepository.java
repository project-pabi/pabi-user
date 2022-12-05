package com.pabi.pabiuser.infrastructure.user;

import com.pabi.pabiuser.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByIdAndWithdrawalFalse(Long userId);
  Optional<User> findByNickName(String nickName);
  Optional<User> findByEmail(String email);
  Optional<User> findByUuid(String uuid);
}
