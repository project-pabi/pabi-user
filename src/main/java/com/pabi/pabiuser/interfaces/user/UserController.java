package com.pabi.pabiuser.interfaces.user;

import com.pabi.pabiuser.application.user.UserFacade;
import com.pabi.pabiuser.common.response.CommonResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.validation.Valid;
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
 
  @GetMapping("/{nickName}/exist")
  @ApiOperation(value = "닉네임 중복체크")
  @ApiImplicitParam(
      name = "nickName"
      , value = "유저 닉네임"
      , required = true)
  public CommonResponse<Boolean> nickNameDuplicateCheck(@PathVariable("nickName") String nickName) {
    var response = userFacade.nickNameDuplicateCheck(nickName);
    return CommonResponse.success(response);
  }

  @GetMapping("/{email}/exist")
  @ApiOperation(value = "닉네임 중복체크")
  @ApiImplicitParam(
      name = "email"
      , value = "유저 이메일"
      , required = true)
  public CommonResponse<Boolean> emailDuplicateCheck(@PathVariable("email") String email) {
    var response = userFacade.emailDuplicateCheck(email);
    return CommonResponse.success(response);
  }

  @PostMapping("/")
  @ApiOperation(value = "유저 생성")
  @ApiResponse()
  public CommonResponse<Long> inputUser(@RequestBody @Valid UserDto.UserRequest request) {
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
  public CommonResponse modifyUser(@PathVariable("userId") Long userId, @RequestBody @Valid UserDto.UserModifyRequest request) {
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
