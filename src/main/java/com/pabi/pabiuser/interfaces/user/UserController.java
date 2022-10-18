package com.pabi.pabiuser.interfaces.user;

import com.pabi.pabiuser.application.user.UserFacade;
import com.pabi.pabiuser.common.response.CommonResponse;
import com.pabi.pabiuser.interfaces.user.UserDto.UserModifyRequest;
import com.pabi.pabiuser.interfaces.user.UserDto.UserRequest;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserDtoMapper userDtoMapper;

  private final UserFacade userFacade;

  @GetMapping("/{userId}")
  @ApiOperation(value = "유저 프로필 조회")
  @ApiImplicitParam(
      name = "userId"
      , value = "유저 PK"
      , required = true)
  public CommonResponse<UserDto.UserResponse> findUserInfo(@PathVariable("userId") Long userId) {
    var info = userFacade.findUserInfo(userId);
    var response = userDtoMapper.of(info);
    return CommonResponse.success(response, "조회 되었습니다.");
  }

  @PostMapping("/")
  @ApiOperation(value = "유저 생성")
  public CommonResponse<Long> inputUser(@RequestBody UserDto.UserRequest request) {
    var command = userDtoMapper.of(request);
    var response = userFacade.inputUser(command);
    return CommonResponse.success(response, "생성 되었습니다.");
  }

  @PatchMapping("/{userId}")
  @ApiOperation(value = "유저 수정")
  @ApiImplicitParam(
      name = "userId"
      , value = "유저 PK"
      , required = true)
  public CommonResponse modifyUser(@PathVariable("userId") Long userId, @RequestBody UserDto.UserModifyRequest request) {
    var command = userDtoMapper.of(userId, request);
    userFacade.modifyUser(command);
    return CommonResponse.success(null, "수정 되었습니다.");
  }

  @DeleteMapping("/{userId}")
  @ApiOperation(value = "유저 삭제")
  @ApiImplicitParam(
      name = "userId"
      , value = "유저 PK"
      , required = true)
  public CommonResponse deleteUser(@PathVariable("userId") Long userId) {
    userFacade.deleteUser(userId);
    return CommonResponse.success(null, "삭제 되었습니다.");
  }

}
