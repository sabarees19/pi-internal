package com.pirai.usermanagement.utils.mapper;

import com.pirai.usermanagement.dto.request.UserRequest;
import com.pirai.usermanagement.dto.response.UserResponse;
import com.pirai.usermanagement.persistence.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapToUserEntity(UserRequest userRequest);

    UserResponse mapToUserResponse(User user);

}