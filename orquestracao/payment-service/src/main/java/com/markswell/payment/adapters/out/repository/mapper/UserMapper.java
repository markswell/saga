package com.markswell.payment.adapters.out.repository.mapper;

import com.markswell.payment.adapters.out.repository.entity.UserEntity;
import com.markswell.payment.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}
