package com.pabi.pabiuser.infrastructure.user;

import com.pabi.pabiuser.domain.user.PabiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<PabiUser,Long> {
  PabiUser findByEmail(String email);
}
