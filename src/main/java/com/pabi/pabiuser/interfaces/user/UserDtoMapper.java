package com.pabi.pabiuser.interfaces.user;

import com.pabi.pabiuser.domain.user.UserCommand;
import com.pabi.pabiuser.domain.user.UserInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserDtoMapper {

  @Mappings({
      @Mapping(source = "request.userId", target = "userIdCommand")})
   UserCommand.UserRequest of (UserDto.UserRequest request);


  @Mappings({
      @Mapping(source = "info.email", target = "userId")})
  UserDto.UserResponse of(UserInfo.getUserOneInfo info);
}
