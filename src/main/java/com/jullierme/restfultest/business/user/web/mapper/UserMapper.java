package com.jullierme.restfultest.business.user.web.mapper;

import com.jullierme.restfultest.business.user.web.dto.UserRequest;
import com.jullierme.restfultest.business.user.web.dto.UserResponse;
import com.jullierme.restfultest.domain.User;

public interface UserMapper {
    User toUser(UserRequest user);
    UserResponse toResponse(User user);
}
