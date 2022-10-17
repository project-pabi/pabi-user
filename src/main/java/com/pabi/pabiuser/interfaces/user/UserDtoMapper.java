package com.pabi.pabiuser.interfaces.user;

import com.pabi.pabiuser.domain.user.UserCommand;
import com.pabi.pabiuser.domain.user.UserInfo;
import com.pabi.pabiuser.interfaces.user.UserDto.UserModifyRequest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserDtoMapper {

  UserDto.UserResponse of(UserInfo.Main info);

  UserCommand.Request of(UserDto.UserRequest request);
  UserCommand.ModifyRequest of(UserDto.UserModifyRequest request);
}
