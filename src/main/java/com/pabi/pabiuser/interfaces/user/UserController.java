package com.pabi.pabiuser.interfaces.user;

import com.pabi.pabiuser.application.user.UserFacade;
import com.pabi.pabiuser.common.response.CommonResponse;
import com.pabi.pabiuser.domain.user.UserCommand;
import com.pabi.pabiuser.domain.user.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserDtoMapper userDtoMapper;

  private final UserFacade userFacade;

  @GetMapping("/{userId}")
  public CommonResponse getUserOne(@PathVariable("userId")String userId, UserDto.UserRequest request) {
    var command = userDtoMapper.of(request);
    var info = userFacade.getUserOne(command);
    var response = userDtoMapper.of(info);
    return CommonResponse.success(response);

  }

}
