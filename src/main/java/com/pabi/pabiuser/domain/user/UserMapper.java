package com.pabi.pabiuser.domain.user;

import com.pabi.pabiuser.domain.user.UserInfo.Main;
import com.pabi.pabiuser.interfaces.user.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserMapper {

  UserInfo.Main of(User user);
}
