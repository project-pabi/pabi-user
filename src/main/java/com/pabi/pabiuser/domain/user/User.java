package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.domain.user.address.Address;
import com.sun.istack.NotNull;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NoArgsConstructor
@Getter
@Setter(AccessLevel.PROTECTED)
@Table(name = "pabi_user")
public class User {

  @Column(unique = true)
  private String uuid = UUID.randomUUID().toString();

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Column(unique = true)
  private String email;

  @NotNull
  @Column(unique = true)
  private String nickName;

  @NotNull
  private String password;

  @Embedded
  private Address address;

  @NotNull
  @Column(columnDefinition = "boolean default false")
  private boolean withdrawal = false;

  public static User createUser(UserCommand.Request request) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    User user = new User();

    user.setEmail(request.getEmail());
    user.setNickName(request.getNickName());
    user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    user.setAddress(request.getAddress());
    user.setWithdrawal(false);

    return user;
  }

  public void modifyUser(UserCommand.ModifyRequest request) {
    this.email = request.getEmail();
    this.nickName = request.getNickName();
    this.address = request.getAddress();
  }

  public void withdrawal() {
    this.withdrawal = true;
  }
}
