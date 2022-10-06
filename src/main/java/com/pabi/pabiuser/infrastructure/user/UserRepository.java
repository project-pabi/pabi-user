package com.pabi.pabiuser.infrastructure.user;

import com.pabi.pabiuser.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  User findByEmail(String email);
}
